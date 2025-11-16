package com.example.autosystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public VehicleModel() {}
    public VehicleModel(String name, Brand brand){this.name = name; this.brand = brand;}

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public Brand getBrand(){return brand;}
    public void setBrand(Brand brand){this.brand = brand;}
}
