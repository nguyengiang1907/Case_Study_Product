package com.example.shoppe.service.server;

import com.example.shoppe.model.Product;
import com.example.shoppe.service.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOAdmin implements IProductDAOAdmin {
    JDBC jdbc = new JDBC();
    private final String SELECT_ALL_PRODUCT = "SELECT * FROM products";
    private final String INSERT_INTO_PRODUCT = "INSERT INTO products(name,price,picture,quantity,detail) VALUES(?,?,?,?,?)";
    private final String UPDATE_SET_PRODUCT = "UPDATE products SET name = ?,price = ?,picture = ?,quantity = ?,detail = ? WHERE id = ?";
    private final String SELECT_ALL_PRODUCT_ID = "SELECT * FROM products WHERE id = ?";
    private final String DELETE_ALL_PRODUCT = "DELETE FROM products WHERE id = ?";

    @Override
    public List<Product> selectAllProduct() throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCT);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            String detail = resultSet.getString("detail");
            productList.add(new Product(id, name, price, picture, quantity, detail));
        }
        return productList;
    }

    @Override
    public void insertIntoProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getPicture());
        preparedStatement.setInt(4, product.getQuantity());
        preparedStatement.setString(5, product.getDetail());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean updateProduct(int id ,Product product) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SET_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getPicture());
        preparedStatement.setInt(4, product.getQuantity());
        preparedStatement.setString(5, product.getDetail());
        preparedStatement.setInt(6,id);
        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        Product product = new Product();
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int iD = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getInt("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            String detail = resultSet.getString("detail");
            product = new Product(iD,name,price,picture,quantity,detail);
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_PRODUCT);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }
}
