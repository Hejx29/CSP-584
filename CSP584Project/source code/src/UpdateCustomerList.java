import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateCustomerList")
//This servlet is only include function of updating product
public class UpdateCustomerList extends HttpServlet {
	
    private String error_msg; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        

        String Username = request.getParameter("Username");
        String Street = request.getParameter("Street"); 
        String City= request.getParameter("City");
        String State = request.getParameter("State");
        int ZipCode = Integer.parseInt(request.getParameter("ZipCode"));
        String Email = request.getParameter("Email"); 
        String Phone= request.getParameter("Phone");

        if (MySqlDataStoreUtilities.updateCustomerInfo(Username, Street, City, State, ZipCode,Email,Phone)) {
        	error_msg = "Customer is updated successfully";
        	request.setAttribute("updateCustomerMsg", error_msg);
        	RequestDispatcher rd = request.getRequestDispatcher("updateCustomerSuccess.jsp"); 
        	rd.forward(request, response);
            
        	
        }
        
    }   
        
}

