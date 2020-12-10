

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Product;

/**
 * Servlet implementation class getProduct
 */
@WebServlet("/getProduct")
public class getProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        HttpSession session = request.getSession(true);
        ArrayList<Product> Productslsit = MySqlDataStoreUtilities.getNewProduct();
        ArrayList<Product> allProducts = MySqlDataStoreUtilities.getAllProduct();
        session.setAttribute("product", Productslsit);
        session.setAttribute("allProducts", allProducts);
        RequestDispatcher rd = request.getRequestDispatcher("Tool.jsp");
        rd.forward(request, response);

    }

}
