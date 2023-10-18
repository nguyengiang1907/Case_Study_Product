package com.example.shoppe.controller.Client;

import com.example.shoppe.model.Basket;
import com.example.shoppe.model.Product;
import com.example.shoppe.service.client.IProductDAO;
import com.example.shoppe.service.client.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductDAO iProductDAO;
    Product product;

    @Override
    public void init() throws ServletException {
        iProductDAO = new ProductDAO();
        product = new Product();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    addBasketProduct(request, response);
                    break;
                case "basket":
                    selectAllBasket(request, response);
                    break;
                case "search":
                    searchNameProduct(request, response);
                    break;
                case "buy":
                    buyProduct(request,response);
                    break;
                case "dropBuy":
                    deleteProductBuy(request,response);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "show":
                    selectIdProduct(request, response);
                case "delete":
                    deleteFromBasket(request, response);
                case "showBuy":
                    showBuyProduct(request,response);
                default:
                    selectAllProduct(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected void selectAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> daoList = iProductDAO.selectAllProduct();
        request.setAttribute("lists", daoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void selectIdProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> list = iProductDAO.selectIdProduct(id);
        request.setAttribute("product", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/show.jsp");
        dispatcher.forward(request, response);
    }

    protected void addBasketProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = iProductDAO.findById(id);
        Product newProduct = new Product(product.getId(), product.getName(), product.getPrice(), product.getPicture(), product.getQuantity());
        iProductDAO.insertIntoBasket(newProduct);
//        selectAllProduct(request, response);
        response.sendRedirect("/products");

    }

    protected void selectAllBasket(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Basket> basketList = iProductDAO.selectAllBasket();
        request.setAttribute("listBasket", basketList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/basket.jsp");
        dispatcher.forward(request, response);
    }

    protected void deleteFromBasket(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        iProductDAO.deleteBasketId(id);
        selectAllBasket(request, response);
    }

    protected void searchNameProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String name = request.getParameter("search");
        List<Product> productList = iProductDAO.searchNameProduct(name);
        request.setAttribute("list", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/search.jsp");
        dispatcher.forward(request, response);
    }
    protected void buyProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductDAO.findById(id);
        Product buyProduct = new Product(product.getId(),product.getName(),product.getPrice(),product.getPicture(),product.getQuantity());
        iProductDAO.buyProduct(buyProduct);

        response.sendRedirect("/products");
    }
    protected void showBuyProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Product> buyProduct = iProductDAO.showBuyProduct();
        request.setAttribute("buyProduct",buyProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client/buy.jsp");
        dispatcher.forward(request,response);
    }
    protected void deleteProductBuy(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductDAO.deleteProductBuy(id);
        showBuyProduct(request,response);
    }
}
