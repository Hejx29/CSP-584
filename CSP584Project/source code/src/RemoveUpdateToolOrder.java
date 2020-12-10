

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveUpdateToolOrder
 */
@WebServlet("/RemoveUpdateToolOrder")
public class RemoveUpdateToolOrder extends HttpServlet {
	private String error_msg; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int ToolOrderId = Integer.parseInt(request.getParameter("OrderId"));
	        String FullName = request.getParameter("FullName");
	        String ProductName = request.getParameter("ProductName");
	        String Price = request.getParameter("Price");
	        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
	        String Street = request.getParameter("Street");
	        String City = request.getParameter("City");
	        String State = request.getParameter("State");
	        String Zip = request.getParameter("Zip");
	        
	        if (request.getParameter("ToolOrder") != null && request.getParameter("ToolOrder").equals("Remove")) {
	            //Remove Product
	            if (MySqlDataStoreUtilities.removeToolsOrder(ToolOrderId)) {
	            	error_msg = "Tools Order is deleted successfully";
	            	request.setAttribute("removeToolsOrderMsg", error_msg);
	            	RequestDispatcher rd = request.getRequestDispatcher("removeToolsOrder.jsp"); 
	            	rd.forward(request, response);
	                
	            }else {
	            	error_msg = "can not delete product!";
	            	}
	        }
	        else if (request.getParameter("ToolOrder") != null && request.getParameter("ToolOrder").equals("Update")) {
         	request.setAttribute("OrderId", ToolOrderId);
         	request.setAttribute("FullName", FullName);
         	request.setAttribute("ProductName", ProductName);
         	request.setAttribute("Price", Price);
         	request.setAttribute("Quantity", Quantity);
         	request.setAttribute("Street", Street);
         	request.setAttribute("City", City);
         	request.setAttribute("State", State);
         	request.setAttribute("Zip", Zip);
         	
         	RequestDispatcher rd = request.getRequestDispatcher("updatetoolOrder.jsp"); 
         	rd.forward(request, response); 
         	
         }
	}

}
