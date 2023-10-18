package com.example.shoppe.controller.Admin;

import com.example.shoppe.HelloServlet;
import com.example.shoppe.model.Product;
import com.example.shoppe.service.server.IProductDAOAdmin;
import com.example.shoppe.service.server.ProductDAOAdmin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServletAdmin", value = "/admin")
public class ProductServletAdmin extends HelloServlet {
    IProductDAOAdmin daoAdmin;

    @Override
    public void init() {
        daoAdmin = new ProductDAOAdmin();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        try {
            switch (action){
                case "create" :
                    insertIntoProduct(request,response);
                    break;
                case "update":
                    updateProduct(request,response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void insertIntoProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
            String name = request.getParameter("name");
            double price =Double.parseDouble(request.getParameter("price"));
            String picture = request.getParameter("picture");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String detail = request.getParameter("detail");
            Product product = new Product(name,price,picture,quantity,detail);
            daoAdmin.insertIntoProduct(product);
            response.sendRedirect("/admin");
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUd"));
        String name = request.getParameter("nameUd");
        double price = Double.parseDouble(request.getParameter("priceUd"));
        String picture = request.getParameter("pictureUd");
        int quantity =Integer.parseInt(request.getParameter("quantityUd"));
        String detail = request.getParameter("detailUd");
        Product product = new Product(id,name,price,picture,quantity,detail);
        daoAdmin.updateProduct(id,product);
        response.sendRedirect("/admin");

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action){
                case "create":
                    showNewForm(request,response);
                    break;
                case "update":
                    showUpDateForm(request,response);
                    break;
                case  "delete":
                    deleteFormProduct(request,response);
                default:
                    selectAllProduct(request,response);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void selectAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> productList = daoAdmin.selectAllProduct();
        request.setAttribute("list",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("server/list.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("server/insert.jsp").forward(request,response);
    }
    private void showUpDateForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = daoAdmin.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("server/update.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteFormProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        daoAdmin.deleteProduct(id);
        daoAdmin.selectAllProduct();
    }
}
