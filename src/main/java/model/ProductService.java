package model;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static ProductService productService;

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    private ProductRepository repository;

    private ProductService() {
        repository = ProductRepository.getInstance();
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

}
