import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServiceOrder")
//This servlet is only include function of updating product
public class UpdateServiceOrder extends HttpServlet {
	private String error_msg; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        
        int orderId= Integer.parseInt(request.getParameter("OrderId"));
        String productId = request.getParameter("ServiceId");
        String username = request.getParameter("Username"); 
        String serviceName= request.getParameter("ServiceName");
        String serviceDetail = request.getParameter("ServiceDetail");
        String serviceDate = request.getParameter("serviceDate");
        String serviceTime = request.getParameter("serviceTime");
        String servicePrice = request.getParameter("servicePrice");

        if (MySqlDataStoreUtilities.UpdateServiceOrde(orderId,productId,  username, serviceName, serviceDetail,serviceDate,serviceTime,servicePrice)) {
        	error_msg = "service order is updated successfully";
        	request.setAttribute("updateserviceorderMsg", error_msg);
        	RequestDispatcher rd = request.getRequestDispatcher("updateServiceOrderSuccess.jsp"); 
        	rd.forward(request, response);
            
        	
        }

    }
}


