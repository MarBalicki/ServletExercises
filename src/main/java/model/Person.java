package model;

public class Person {
    private String name;
    private String beerType;
    private String beer;

    public Person(String name, String beerType, String beer) {
        this.name = name;
        this.beerType = beerType;
        this.beer = beer;
    }

    public String getName() {
        return name;
    }

    public String getBeerType() {
        return beerType;
    }

    public String getBeer() {
        return beer;
    }

}
