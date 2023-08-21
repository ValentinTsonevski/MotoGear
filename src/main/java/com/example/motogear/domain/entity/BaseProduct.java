package com.example.motogear.domain.entity;

import com.example.motogear.domain.enums.Gender;
import com.example.motogear.domain.enums.Size;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    public BaseProduct() {
    }

    public BaseProduct(Long id, String name, double price, Size size, Gender gender, String description,String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.gender = gender;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public BaseProduct setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BaseProduct setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BaseProduct setPrice(double price) {
        this.price = price;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public BaseProduct setSize(Size size) {
        this.size = size;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public BaseProduct setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getType() {
        return type;
    }

    public BaseProduct setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BaseProduct setDescription(String description) {
        this.description = description;
        return this;
    }
}
