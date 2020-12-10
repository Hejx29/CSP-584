

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class replyMessage
 */
@WebServlet("/replyMessage")
public class replyMessage extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("Customeremail"); 
		request.setAttribute("Email", Email);
		RequestDispatcher rd = request.getRequestDispatcher("reply.jsp"); 
    	rd.forward(request, response); 
        
	}

}
