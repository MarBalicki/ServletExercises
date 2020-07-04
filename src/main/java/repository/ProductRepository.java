package repository;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public void deleteProduct(Integer id) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId().equals(id)).findFirst();
        product.ifPresent(value -> products.remove(value));
    }

    public void editProduct(Product product) {
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId().equals(product.getName())).findFirst();
        if (productOptional.isPresent()) {
            Product.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .category(product.getCategory())
                    .quantity(product.getQuantity())
                    .build();
        }
    }

    public Optional<Product> filterProducts(String filter) {
        return products.stream()
                .filter(p -> p.getName().contains(filter)).findAny();
    }

    public Product getProduct(Integer id) {
        Optional<Product> product = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        return product.orElse(null);
    }

    public Optional<Product> findProductById(Integer id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
