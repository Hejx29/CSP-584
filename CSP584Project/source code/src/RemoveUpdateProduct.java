

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
@WebServlet("/RemoveUpdateProduct")
public class RemoveUpdateProduct extends HttpServlet {
	private String error_msg; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();

	        Utilities utility = new Utilities(request, pw);

	        int productId = Integer.parseInt(request.getParameter("productId"));
	        String productName = request.getParameter("productName");
	        String productPrice = request.getParameter("productPrice");
	        String productImage = request.getParameter("productImage");
	        String productInventory = request.getParameter("productInventory");
	        String productStatus = request.getParameter("productStatus");
	        String productDescribe = request.getParameter("productDescribe");
	        

	        if (request.getParameter("Product") != null && request.getParameter("Product").equals("Remove")) {
	            //Remove Product
	            if (MySqlDataStoreUtilities.removeProduct(productId)) {
	            	error_msg = "Product is deleted successfully";
	            	request.setAttribute("removeProductMsg", error_msg);
	            	RequestDispatcher rd = request.getRequestDispatcher("removeproduct.jsp"); 
	            	rd.forward(request, response);
	                
	            }else {
	            	error_msg = "can not delete product!";
	            	}
	                
	            }else if (request.getParameter("Product") != null && request.getParameter("Product").equals("Update")) {
	            	request.setAttribute("Id", productId);
	            	request.setAttribute("Name", productName);
	            	request.setAttribute("Price", productPrice);
	            	request.setAttribute("Image", productImage);
	            	request.setAttribute("Inventory", productInventory);
	            	request.setAttribute("Status", productStatus);
	            	request.setAttribute("Describe", productDescribe);
	            	
	            	
	            	RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp"); 
	            	rd.forward(request, response); 
	            	
	            }
	}

}
