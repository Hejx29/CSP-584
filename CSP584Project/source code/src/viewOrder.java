
import Bean.CartItem;
import Bean.Product;
import Bean.ServiceOrderItem;
import Bean.ToolsOrderItem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewOrder")

public class viewOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        HttpSession session = request.getSession(true);
        ArrayList<ServiceOrderItem> ServiceOrderItemlsit = MySqlDataStoreUtilities.getAllServiceOrder();
        ArrayList<ToolsOrderItem> ToolOrderItemlsit = MySqlDataStoreUtilities.getAllToolsOrder();
        session.setAttribute("ServiceOrderItem", ServiceOrderItemlsit);
        session.setAttribute("ToolOrderItemlsit", ToolOrderItemlsit);
        RequestDispatcher rd = request.getRequestDispatcher("view orders.jsp"); 
    	rd.forward(request, response);
			
			 }  
}


    

