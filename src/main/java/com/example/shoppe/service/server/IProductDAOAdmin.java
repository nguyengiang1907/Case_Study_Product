package com.example.shoppe.service.server;

import com.example.shoppe.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAOAdmin {
    List<Product> selectAllProduct() throws SQLException, ClassNotFoundException;
    void insertIntoProduct(Product product) throws SQLException, ClassNotFoundException;
    boolean updateProduct(int id,Product product) throws SQLException, ClassNotFoundException;
    Product findById(int id) throws SQLException, ClassNotFoundException;
    boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;
}
