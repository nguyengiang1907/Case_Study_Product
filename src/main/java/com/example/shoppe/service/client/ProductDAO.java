package com.example.shoppe.service.client;

import com.example.shoppe.model.Basket;
import com.example.shoppe.model.Product;
import com.example.shoppe.service.JDBC;
import com.example.shoppe.service.client.IProductDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    JDBC connectSQL = new JDBC();
    private final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
    private final String SELECT_PRODUCTS_ID = "SELECT * FROM products WHERE id = ?";
    private final String INSERT_INTO_BASKETS = "INSERT INTO baskets(idProduct,nameProduct,priceProduct,pictureProduct,quantityProduct) VALUES (?,?,?,?,?)";
    private final String SELECT_ALL_BASKETS = "SELECT * FROM baskets";
    private final String DELETE_FROM_BASKET = "DELETE FROM baskets WHERE idBasket = ?";
    private final String SEARCH_NAME_PRODUCT = "SELECT * FROM products WHERE name LIKE  ? ";
    private final String BUY_PRODUCT = "INSERT INTO buy(idProduct,pictureProduct,nameProduct,quantityProduct,priceProduct) VALUES(?,?,?,?,?)";
    private final String SELECT_BUY_PRODUCT = "SELECT * FROM buy";
    private final String DELETE_FROM_BUY = "DELETE FROM buy WHERE idProduct = ?";


    @Override
    public List<Product> selectAllProduct() throws SQLException, ClassNotFoundException {
        List<Product> lists = new ArrayList<>();
        Connection connection = connectSQL.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getInt("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            lists.add(new Product(id, name, price, picture, quantity));
        }
        return lists;
    }

    @Override
    public List<Product> selectIdProduct(int id) throws SQLException, ClassNotFoundException {
        List<Product> lists = new ArrayList<>();
        Connection connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int iD = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getInt("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            String detail = resultSet.getString("detail");
            lists.add(new Product(iD, name, price, picture, quantity, detail));
           }
        return lists;
    }

    @Override
    public void insertIntoBasket(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BASKETS);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getPicture());
        preparedStatement.setInt(5, product.getQuantity());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Basket> selectAllBasket() throws SQLException, ClassNotFoundException {
        List<Basket> baskets = new ArrayList<>();
        Connection connection = connectSQL.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_BASKETS);
        while (resultSet.next()) {
            int idBasket = resultSet.getInt("idBasket");
            int idProduct = resultSet.getInt("idProduct");
            String nameProduct = resultSet.getString("nameProduct");
            double priceProduct = resultSet.getDouble("priceProduct");
            String picture = resultSet.getString("pictureProduct");
            int quantityProduct = resultSet.getInt("quantityProduct");
            baskets.add(new Basket(idBasket, idProduct, nameProduct, priceProduct, picture, quantityProduct));
        }
        return baskets;
    }

    @Override
    public Product findById(int productId) throws SQLException, ClassNotFoundException {
        Connection connection = connectSQL.getConnection();
        Product product = null;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_ID);
        preparedStatement.setInt(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getInt("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            product = new Product(id, name, price, picture, quantity);

        }

        return product;
    }

    @Override
    public boolean deleteBasketId(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BASKET);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public List<Product> searchNameProduct(String name) throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<>();
        Connection connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_PRODUCT);
        preparedStatement.setString(1, "%" + name + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name2 = resultSet.getString("name");
            double price = resultSet.getInt("price");
            String picture = resultSet.getString("picture");
            int quantity = resultSet.getInt("quantity");
            list.add(new Product(id, name2, price, picture, quantity));
        }
        return list;
    }

    @Override
    public void buyProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection  connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(BUY_PRODUCT);
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getPicture());
        preparedStatement.setString(3,product.getName());
        preparedStatement.setInt(4,product.getQuantity());
        preparedStatement.setDouble(5,product.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Product> showBuyProduct() throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<>();
        Connection connection = connectSQL.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_BUY_PRODUCT);
        while (resultSet.next()){
            int idProduct = resultSet.getInt("idProduct");
            String nameProduct = resultSet.getString("nameProduct");
            String pictureProduct = resultSet.getString("pictureProduct");
            int quantityProduct = resultSet.getInt("quantityProduct");
            double priceProduct = resultSet.getDouble("priceProduct");
            list.add(new Product(idProduct,nameProduct,priceProduct,pictureProduct,quantityProduct));
        }
        return list;
    }

    @Override
    public boolean deleteProductBuy(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = connectSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BUY);
        preparedStatement.setInt(1,id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

}
