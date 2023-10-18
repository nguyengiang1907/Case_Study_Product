package com.example.shoppe.service.client;

import com.example.shoppe.model.Basket;
import com.example.shoppe.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct() throws SQLException, ClassNotFoundException;

    List<Product> selectIdProduct(int id) throws SQLException, ClassNotFoundException;

    void insertIntoBasket(Product product) throws SQLException, ClassNotFoundException;

    List<Basket> selectAllBasket() throws SQLException, ClassNotFoundException;

    Product findById(int productId) throws SQLException, ClassNotFoundException;

    boolean deleteBasketId(int id) throws SQLException, ClassNotFoundException;

    List<Product> searchNameProduct(String name) throws SQLException, ClassNotFoundException;
    void buyProduct(Product product) throws SQLException, ClassNotFoundException;
    List<Product> showBuyProduct() throws SQLException, ClassNotFoundException;
    boolean deleteProductBuy(int id) throws SQLException, ClassNotFoundException;
}
