

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	
	private String error_msg; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession(true);

        Utilities utility = new Utilities(request, pw);

        if (!utility.isLoggedin()) {
            request.setAttribute("msg", "Please Login to contact us");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        String Customerid = (String)session.getAttribute("username");
        String Customername = request.getParameter("Customername");
        String Customeremail = request.getParameter("Customeremail");
        String Customerphone = request.getParameter("Customerphone");
        String Customermessage = request.getParameter("Customermessage");
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        int contactId = Integer.parseInt(df.format(new Date()));  //设置订单号为当前下单时间的时分秒
        
        if (MySqlDataStoreUtilities.storeContactInfo(contactId, Customerid, Customername, Customeremail, Customerphone,Customermessage)) {
        	error_msg = "We have received your message!";
        	request.setAttribute("contactMsg", error_msg);
        	RequestDispatcher rd = request.getRequestDispatcher("Contact.jsp"); 
        	rd.forward(request, response);
        }
	}

}
