import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@WebServlet("/Payment")

public class Payment extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		

		Utilities utility = new Utilities(request, pw);
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to Pay");
			response.sendRedirect("Login");
			return;
		}
	
		// get the payment details like credit card no address processed from cart servlet	
		String fullName=request.getParameter("fullName");
		String streetAddress=request.getParameter("streetAddress");
		String zipCode=request.getParameter("zipCode");
		String creditCardNo=request.getParameter("creditCardNo");
		String optionvalue = request.getParameter("optionvalue");
		System.out.print("the user address is" +streetAddress);
		System.out.print(creditCardNo);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 14);
		Date date = cal.getTime();
		String DATE_FORMAT = "MM/dd/yyyy"; 
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		String deliverydate = sdf.format(date);
		Calendar cal2 = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 9);
		Date date2 = cal2.getTime();
		String DATE_FORMAT2 = "MM/dd/yyyy"; 
		SimpleDateFormat sdf2 = new SimpleDateFormat(DATE_FORMAT2);				
		String deliverydate2 = sdf2.format(date2);
		
		if(!streetAddress.isEmpty() && !creditCardNo.isEmpty()&& !fullName.isEmpty() )
		{
			//Random rand = new Random(); 
			//int orderId = rand.nextInt(100);
			int orderId=utility.getOrderPaymentSize()+1;

			//iterate through each order

			for (OrderItem oi : utility.getCustomerOrders())
			{

				//set the parameter for each column and execute the prepared statement

				utility.storePayment(orderId,oi.getName(),oi.getPrice(),fullName,streetAddress,zipCode,creditCardNo);
			}

			//remove the order details from cart after processing
			
			OrdersHashMap.orders.remove(utility.username());	
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h2>Your Order");
			pw.print("&nbsp&nbsp");  
			pw.print("is stored ");
			pw.print("<br>Your Order No is "+(orderId));
			if(optionvalue.equals("homedelivery")) {
				pw.print("<br>The order will be delivered by " + deliverydate + "");
				pw.print("<br>The later time  you can cancle the order is " + deliverydate2 + "");
			}
			
			pw.print("</h2></div></div></div>");		
			utility.printHtml("Footer.html");
		}else 
		{
			utility.printHtml("Header.html");
			utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h4 style='color:red'>Please enter valid address and creditcard number</h4>");
			pw.print("</h2></div></div></div>");		
			utility.printHtml("Footer.html");
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		
	}
}
