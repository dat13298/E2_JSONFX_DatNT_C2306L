package com.c2306l.myproject.Entity;

public class Product {
    private String id;
    private Category category;
    private String name;
    private double price;
    private String image;
    private String description;

    public Product(){;}

    public Product(String id, Category category, String name, double price, String image, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
