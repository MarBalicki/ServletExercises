package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {

    private static ProductRepository productRepository;

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

//    public void saveProduct(Product product) {
//
//    }

    private List<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
    }

    public void save(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }
}
