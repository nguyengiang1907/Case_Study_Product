package com.example.shoppe.model;

public class Product {
    protected int id;
    protected String name;
    protected double price;
    protected String picture;
    protected int quantity;
    protected String detail;

    public Product() {
    }

    public Product(int id, String name, double price, String picture, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public Product(String name, double price, String picture, int quantity, String detail) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
        this.detail = detail;
    }

    public Product(String name, double price, String picture, int quantity) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, String picture, int quantity, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
        this.detail = detail;
    }

    public Product(int id, String name, double price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
