package com.example.shoppe.service.login;

import com.example.shoppe.model.User;

import java.sql.SQLException;
import java.util.List;

public interface ILoginDAO {
    List<User> selectAllUser() throws SQLException, ClassNotFoundException;
    User selectAllUserLogin(String username, String password) throws SQLException, ClassNotFoundException;
}
