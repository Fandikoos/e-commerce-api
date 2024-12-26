package com.personal.localEcommerce.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private int stock;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column
    private String category;

    @ManyToOne()
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(name = "FK_STORE_PRODUCT"))
    private Store store;

}
