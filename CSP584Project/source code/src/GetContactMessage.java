

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ContactInfo;

/**
 * Servlet implementation class GetContactMessage
 */
@WebServlet("/GetContactMessage")
public class GetContactMessage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
        ArrayList<ContactInfo> ContactInfolsit = MySqlDataStoreUtilities.getAllContactInfo();

			
			session.setAttribute("ContactInfo", ContactInfolsit);
	        response.sendRedirect("view contact.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
