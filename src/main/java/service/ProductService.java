package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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

    public void deleteProduct(Integer productId) {
        repository.deleteProduct(productId);
    }

    public void editProduct(Product product) {
        repository.editProduct(product);
    }

    public Optional<Product> filterProducts(String filter) {
        return repository.filterProducts(filter);
    }

    public Product getProduct(Integer id) {
        return repository.getProduct(id);
    }

    public Optional<Product> findProductById(Integer id) {
        return repository.findProductById(id);
    }
}
