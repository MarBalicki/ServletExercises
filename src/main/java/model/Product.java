package model;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Setter
public class Product {

    @Setter
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private Category category;
    private Integer quantity;

}
