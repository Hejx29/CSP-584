

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		private String error_msg;
	    protected void doPost(HttpServletRequest request,
	                          HttpServletResponse response) throws ServletException, IOException {
	    	response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();

	        Utilities utility = new Utilities(request, pw);


	        String Username = request.getParameter("Username");
	        String Street = request.getParameter("Street"); 
	        String City= request.getParameter("City");
	        String State = request.getParameter("State");
	        int ZipCode = Integer.parseInt(request.getParameter("ZipCode"));
	        String Email = request.getParameter("Email"); 
	        String Phone= request.getParameter("Phone");

	        if (MySqlDataStoreUtilities.addCustomer(Username, Street, City,State,ZipCode,Email,Phone)){
	        	error_msg = "add product successful!";
	        }
	        request.setAttribute("addCustomerMsg", error_msg);
	        request.getRequestDispatcher("add customer.jsp").forward(request, response);

	    }
	}


