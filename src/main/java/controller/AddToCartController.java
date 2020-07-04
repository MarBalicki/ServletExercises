package controller;

import model.Product;
import model.ShoppingCart;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AddToCartController", value = "/add-to-cart")
public class AddToCartController extends HttpServlet {

    private ProductService productService = ProductService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid product id" + id);
            resp.sendRedirect("/");
            return;
        }
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        Optional<Product> productById = productService.findProductById(productId);
        if (productById.isPresent()) {
            shoppingCart.addToShoppingCart(productById.get(), 1);
        }
        resp.sendRedirect("/all-products");
    }
}
