

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToolOrder
 */
@WebServlet("/AddToolOrder")
public class AddToolOrder extends HttpServlet {
	private String error_msg;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
      


        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String username = request.getParameter("username");
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String zip = request.getParameter("zip");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String price = request.getParameter("price");
        String creditNo = request.getParameter("creditNo");
        int buyId = Integer.parseInt(request.getParameter("buyId"));
        String deliveryMethod = request.getParameter("deliveryMethod");
        String pickupLocation = request.getParameter("pickupLocation");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String createTime = request.getParameter("createTime");
        
        
        


        if (MySqlDataStoreUtilities.AddToolOrder(orderid,username, productId, productName, fullName, 
        		phone,email,zip,street,city,state,price,creditNo,buyId,deliveryMethod,pickupLocation,quantity,createTime)){
        	error_msg = "add tool order successful!";
        }
        request.setAttribute("addToolOrderMsg", error_msg);
        request.getRequestDispatcher("add tool order.jsp").forward(request, response);

    }

}
