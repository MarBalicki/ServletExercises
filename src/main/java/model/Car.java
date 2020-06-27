package model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Car {
    private Brand brand;
    private String model;
    private BodyStyle bodyStyle;
    private int productionYear;
    private EngineType engineType;
    private double capacity;
    private int mileage;
    private int numberOfDoors;

}
