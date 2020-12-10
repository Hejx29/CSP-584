

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveUpdateProduct
 */
@WebServlet("/RemoveUpdateServiceOrder")
public class RemoveUpdateServiceOrder extends HttpServlet {
	private String error_msg; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        response.setContentType("text/html");

	        int OrderId = Integer.parseInt(request.getParameter("OrderId"));
	        String Username = request.getParameter("Username");
	        String ServiceId = request.getParameter("ServiceId");
	        String ServiceName = request.getParameter("ServiceName");
	        String ServiceDetail = request.getParameter("ServiceDetail");
	        String serviceDate = request.getParameter("serviceDate");
	        String serviceTime = request.getParameter("serviceTime");
	        String servicePrice = request.getParameter("servicePrice");
	        
	        if (request.getParameter("ServiceOrder") != null && request.getParameter("ServiceOrder").equals("Remove")) {
	            //Remove Product
	            if (MySqlDataStoreUtilities.removeServiceOrder(OrderId)) {
	            	error_msg = "Service Order is deleted successfully";
	            	request.setAttribute("removeServiceOrderMsg", error_msg);
	            	RequestDispatcher rd = request.getRequestDispatcher("removeServiceOrder.jsp"); 
	            	rd.forward(request, response);
	                
	            }else {
	            	error_msg = "can not delete product!";
	            	}
	                
	            }
	            else if (request.getParameter("ServiceOrder") != null && request.getParameter("ServiceOrder").equals("Update")) {
	            	request.setAttribute("OrderId", OrderId);
	            	request.setAttribute("Username", Username);
	            	request.setAttribute("ServiceId", ServiceId);
	            	request.setAttribute("ServiceName", ServiceName);
	            	request.setAttribute("ServiceDetail", ServiceDetail);
	            	request.setAttribute("serviceDate", serviceDate);
	            	request.setAttribute("serviceTime", serviceTime);
	            	request.setAttribute("servicePrice", servicePrice);
	            	RequestDispatcher rd = request.getRequestDispatcher("updateServiceOrder.jsp"); 
	            	rd.forward(request, response); 
	            	
	            }
	        
	        
	        
	        
	        
	        
	        
//	       
	}

}
