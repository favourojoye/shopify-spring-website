package com.spaddemplbydeptCRUD.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
public class Product {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Size;
    private String Color;
    private String Price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Category category;


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String lastName) {
        this.Color = Color;
    }

    public String getPrize() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public Category getDepartment() {
        return category;
    }

    public void setDepartment(Category category) {
        this.category = category;
    }

}