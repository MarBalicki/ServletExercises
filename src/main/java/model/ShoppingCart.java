package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {

    private List<ProductItem> productItems;
    private Integer totalPrice;

    public ShoppingCart() {
        productItems = new ArrayList<>();
        totalPrice = 0;
    }

    public void addToShoppingCart(Product product, Integer quantity) {
        Optional<ProductItem> productItemOptional = productItems.stream()
                .filter(p -> p.getProduct().equals(product))
                .findFirst();
        if (productItemOptional.isEmpty()) {
            ProductItem productItem = new ProductItem(product, quantity);
            productItems.add(productItem);
        } else {
            productItemOptional.get().increaseQuantity(quantity);
        }
        int productCost = product.getPrice() * quantity;
        totalPrice = totalPrice + productCost;
    }

    public void removeFromShoppingCart(Product product) {
        productItems.stream()
                .filter(p -> p.getProduct().equals(product))
                .findFirst()
                .ifPresent(productItem -> productItems.remove(productItem));
    }
}
