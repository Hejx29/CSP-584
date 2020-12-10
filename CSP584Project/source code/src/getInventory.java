

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Product;

/**
 * Servlet implementation class getInventory
 */
@WebServlet("/getInventory")
public class getInventory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
        ArrayList<Product> Inventorylsit = MySqlDataStoreUtilities.getAllProduct();
        session.setAttribute("Inventory", Inventorylsit);
        RequestDispatcher rd = request.getRequestDispatcher("Inventory.jsp"); 
    	rd.forward(request, response);
	}

	

}
