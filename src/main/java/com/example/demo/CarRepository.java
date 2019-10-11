package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CarRepository extends CrudRepository<Car, Long> {
    ArrayList<Car> findCarsByCarMakeContains(String search);
}
