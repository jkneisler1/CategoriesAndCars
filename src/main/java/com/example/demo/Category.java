package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catagoryID;

    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Car> cars;

    public Category() {
    }

    public Category(String categoryName, String description, Set<Car> cars) {
        this.categoryName = categoryName;
        this.description = description;
        this.cars = cars;
    }

    public long getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(long catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
