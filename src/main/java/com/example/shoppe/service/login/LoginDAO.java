package com.example.shoppe.service.login;

import com.example.shoppe.model.Product;
import com.example.shoppe.model.User;
import com.example.shoppe.service.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements ILoginDAO{
    JDBC connecJdbc = new JDBC();
    private final String SELECT_ALL_USER = "SELECT userName,passWord FROM user";
    private final String SELECT_ALL_USER_LOGIN = "SELECT * FROM user where userName = ? and passWord = ?";

    @Override
    public List<User> selectAllUser() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Connection connection = connecJdbc.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER);
        while (resultSet.next()){
            int id = resultSet.getInt("idLogin");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("passWord");
            list.add(new User(id,userName,passWord));
        }
        return list;
    }

    @Override
    public User selectAllUserLogin(String username, String password) throws SQLException, ClassNotFoundException {
        User user = new User();
        Connection connection = connecJdbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER_LOGIN);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int idUser = resultSet.getInt("idLogin");
            String userName = resultSet.getString("userName");
            String passWord = resultSet.getString("passWord");
            user = new User(idUser,userName,passWord);
        }
        return user;
    }
}
