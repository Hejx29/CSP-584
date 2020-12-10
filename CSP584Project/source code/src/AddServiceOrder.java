

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServiceOrder
 */
@WebServlet("/AddServiceOrder")
public class AddServiceOrder extends HttpServlet {
	private String error_msg;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
      


        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String username = request.getParameter("username");
        int serviceid = Integer.parseInt(request.getParameter("serviceid"));
        String servicename = request.getParameter("servicename");
        String servicedetail = request.getParameter("servicedetail");
        String servicedate = request.getParameter("servicedate");
        String servicetime = request.getParameter("servicetime");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String serviceHour = request.getParameter("serviceHour");
        String price = request.getParameter("price");
        String creditNo = request.getParameter("creditNo");
        


        if (MySqlDataStoreUtilities.addServiceOrder(orderid,username, serviceid, servicename, servicedetail, servicedate,servicetime
        		,firstname,lastname,phone,email,zip,street,city,state,serviceHour,price,creditNo)){
        	error_msg = "add service order successful!";
        }
        request.setAttribute("addOrderMsg", error_msg);
        request.getRequestDispatcher("add service.jsp").forward(request, response);

    }
}
