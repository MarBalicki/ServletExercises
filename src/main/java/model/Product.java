package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
public class Product {

    @Setter
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private Category category;
    private Integer quantity;

}
