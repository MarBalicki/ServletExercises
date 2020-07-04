package controller;

import model.Category;
import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProductController", value = "/add-product")
public class AddProductController extends HttpServlet {

    private ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = validateRequest(req);
        if (errorMessage != null) {
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("add-product.jsp").forward(req, resp);
            return;
        }
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        String quantity = req.getParameter("quantity");
        Product product = Product.builder()
                .name(name)
                .price(Integer.parseInt(price))
                .description(description)
                .category(Category.valueOf(category))
                .quantity(Integer.parseInt(quantity))
                .build();
        productService.saveProduct(product);
        resp.sendRedirect("/all-products");
    }

    private String validateRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        String category = req.getParameter("category");
        String quantity = req.getParameter("quantity");
        if (name == null || name.isBlank()) {
            return "Invalid product name!";
        }
        if (price == null || isNotNumeric(price)) {
            return "Invalid product price!";
        }
        if (description == null || description.isBlank()) {
            return "Invalid product description!";
        }
        if (category == null) {
            return "Invalid category!";
        }
        if (quantity == null || isNotNumeric(quantity)) {
            return "Invalid quantity!";
        }
        return null;
    }

    private boolean isNotNumeric(String price) {
        try {
            int temp = Integer.parseInt(price);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }
}
