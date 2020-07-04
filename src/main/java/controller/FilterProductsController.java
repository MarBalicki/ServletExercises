package controller;

import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "FilterProductsController", value = "/filter-products")
public class FilterProductsController extends HttpServlet {

    private ProductService productService = ProductService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filter = req.getParameter("filter");
        Optional<Product> productOptional = productService.filterProducts(filter);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
        }
        resp.sendRedirect("/all-products");
    }
}
