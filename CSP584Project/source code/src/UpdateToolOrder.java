

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateToolOrder
 */
@WebServlet("/UpdateToolOrder")
public class UpdateToolOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error_msg; 
		int orderId= Integer.parseInt(request.getParameter("OrderId"));
        String FullName = request.getParameter("FullName");
        String ProductName= request.getParameter("ProductName");
        String Price = request.getParameter("Price");
        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        
        if (MySqlDataStoreUtilities.UpdateToolOrde(orderId,FullName,ProductName,Price, Quantity,City,State,Zip)) {
        	error_msg = "tool order is updated successfully";
        	request.setAttribute("updatetoolorderMsg", error_msg);
        	RequestDispatcher rd = request.getRequestDispatcher("updateToolOrderSuccess.jsp"); 
        	rd.forward(request, response);
        }
        
	}

}
