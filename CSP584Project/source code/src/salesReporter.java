

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
import Bean.ServiceOrderItem;
import Bean.ToolsOrderItem;

/**
 * Servlet implementation class salesReporter
 */
@WebServlet("/salesReporter")
public class salesReporter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		HashMap<String, ServiceOrderItem> ServiceOrderItemlsit = MySqlDataStoreUtilities.selectServiceSaleAmount();
		HashMap<String, ToolsOrderItem> ToolOrderItemlsit = MySqlDataStoreUtilities.selectToolSaleAmount();
		HashMap<String, ToolsOrderItem> ToolOrderTime = MySqlDataStoreUtilities.selectToolTime();
        session.setAttribute("ServiceOrderItem", ServiceOrderItemlsit);
        session.setAttribute("ToolOrderItemlsit", ToolOrderItemlsit);
        session.setAttribute("ToolOrderTime", ToolOrderTime);
        RequestDispatcher rd = request.getRequestDispatcher("view salesreporter.jsp"); 
    	rd.forward(request, response);
	}

	
}
