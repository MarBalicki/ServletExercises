package controller;

import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetProductToEditController", value = "/product-to-edit")
public class GetProductToEditController extends HttpServlet {

    private ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("edit-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer productId = 0;
        try {
            productId = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid product ID: " + id);
        }

        Product product = productService.getProduct(productId);
        req.setAttribute("product", product);
        req.getRequestDispatcher("edit-product.jsp").forward(req, resp);
    }
}
