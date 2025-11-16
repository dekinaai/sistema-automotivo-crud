package com.example.autosystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private VehicleModel model;

    @Column(nullable=false)
    private Integer year;

    private String color;

    private Long mileage;

    @Column(nullable=false)
    private java.math.BigDecimal price;

    @Column(nullable=false)
    private String status; // e.g. AVAILABLE, SOLD, RESERVED

    public Vehicle(){}

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public VehicleModel getModel(){return model;}
    public void setModel(VehicleModel model){this.model = model;}
    public Integer getYear(){return year;}
    public void setYear(Integer year){this.year = year;}
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}
    public Long getMileage(){return mileage;}
    public void setMileage(Long mileage){this.mileage = mileage;}
    public java.math.BigDecimal getPrice(){return price;}
    public void setPrice(java.math.BigDecimal price){this.price = price;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}
}
