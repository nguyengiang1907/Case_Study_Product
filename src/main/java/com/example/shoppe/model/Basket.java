package com.example.shoppe.model;

public class Basket {
    protected int idBasket;
    protected int idProduct;
    protected String nameProduct;
    protected double priceProduct;
    protected String pictureProduct;
    protected int quantityProduct;

    public Basket() {
    }

    public Basket(int idBasket, int idProduct, String nameProduct, double priceProduct, String pictureProduct, int quantityProduct) {
        this.idBasket = idBasket;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.pictureProduct = pictureProduct;
        this.quantityProduct = quantityProduct;
    }

    public Basket(int idProduct, String nameProduct, double priceProduct, String pictureProduct, int quantityProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.pictureProduct = pictureProduct;
        this.quantityProduct = quantityProduct;
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getPictureProduct() {
        return pictureProduct;
    }

    public void setPictureProduct(String pictureProduct) {
        this.pictureProduct = pictureProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
}
