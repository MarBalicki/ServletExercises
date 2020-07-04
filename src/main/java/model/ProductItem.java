package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductItem {

    private Product product;
    private int quantity;

    public void increaseQuantity(int q) {
        quantity += q;
    }
}
