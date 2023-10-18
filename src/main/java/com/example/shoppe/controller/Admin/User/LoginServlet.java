package com.example.shoppe.controller.Admin.User;

import com.example.shoppe.model.User;
import com.example.shoppe.service.login.ILoginDAO;
import com.example.shoppe.service.login.LoginDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/users")
public class LoginServlet extends HttpServlet {
    ILoginDAO iLoginDAO;

    @Override
    public void init() throws ServletException {
        iLoginDAO = new LoginDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "login":
                    login(request,response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user = iLoginDAO.selectAllUserLogin(userName, passWord);
        if (user != null){
            response.sendRedirect("/products");
        }else {
            response.sendRedirect("login/login.jsp");
        }
    }
}
