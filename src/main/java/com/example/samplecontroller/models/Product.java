package com.example.samplecontroller.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
//    @Id
//    private long id;
    private String name;
    private double price;
    private String image;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Category category;
    private String description;
    private int quantity;
}
