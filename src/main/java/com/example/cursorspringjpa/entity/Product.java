package com.example.cursorspringjpa.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private double price;
    private String description;
    private String manufactureCountry;
    private int manufacturedYear;
    private int expirationYear;

    public Product() {
    }

    public Product(String name, double price, String description, String manufactureCountry, int manufacturedYear, int expirationYear) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactureCountry = manufactureCountry;
        this.manufacturedYear = manufacturedYear;
        this.expirationYear = expirationYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufactureCountry='" + manufactureCountry + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", expirationYear=" + expirationYear +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Long getId() {
        return id;
    }

}
