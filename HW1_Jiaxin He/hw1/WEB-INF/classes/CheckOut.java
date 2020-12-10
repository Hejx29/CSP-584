import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/CheckOut")

//once the user clicks buy now button page is redirected to checkout page where user has to give checkout information

public class CheckOut extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	        Utilities Utility = new Utilities(request, pw);
		storeOrders(request, response);
	}
	
	protected void storeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
        {
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request,pw);
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to add items to cart");
			response.sendRedirect("Login");
			return;
		}
        HttpSession session=request.getSession(); 

		//get the order product details	on clicking submit the form will be passed to submitorder page	
		
	    String userName = session.getAttribute("username").toString();
        String orderTotal = request.getParameter("orderTotal");
        String optionvalue = request.getParameter("optionvalue");
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		
		
		
		pw.print("<form action = 'Payment' method= 'post'>");
        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Order</a>");
		pw.print("</h2><div class='entry'>");
		pw.print("<table  class='gridtable'><tr><td>Customer Name:</td><td>");
		pw.print(userName);
		pw.print("</td></tr>");
		// for each order iterate and display the order name price
		for (OrderItem oi : utility.getCustomerOrders()) 
		{
			pw.print("<tr><td> Product Purchased:</td><td>");
			pw.print(oi.getName()+"</td></tr><tr><td>");
			pw.print("<input type='hidden' name='orderPrice' value='"+oi.getPrice()+"'>");
			pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
			pw.print("Product Price:</td><td>"+ oi.getPrice());
			pw.print("</td></tr>");
		}
		pw.print("<tr><td>");
        pw.print("Total Order Cost</td><td>"+orderTotal);
		pw.print("<input type='hidden' name='orderTotal' value='"+orderTotal+"'>");
		pw.print("</td></tr></table><table><tr></tr><tr></tr>");	
		
		pw.print("<tr><td>");
	    pw.print("Full Name</td>");
		pw.print("<td><input type='text' name='fullName'>");
        pw.print("</td></tr>");
		
		pw.print("<tr><td>");
	    pw.print("Address(street,city,state)</td>");
		pw.print("<td><input type='text' name='streetAddress'>");
        pw.print("</td></tr>");
        
        pw.print("<tr><td>");
	    pw.print("ZipCode</td>");
		pw.print("<td><input type='text' name='zipCode'>");
        pw.print("</td></tr>");
        
        pw.print("<tr><td>");
     	pw.print("Credit/accountNo</td>");
		pw.print("<td><input type='text' name='creditCardNo'>");
		pw.print("</td></tr>");
		
		pw.print("<tr><td>");
		pw.print("Option");
     	pw.print("<td><input type='radio' name='optionvalue' value = 'homedelivery' onclick ='Homedelivery()' checked >");
     	pw.print("Homedelivery</td>");
     	pw.print("<td><input type='radio' name='optionvalue' value = 'storepickup' onclick ='StorePickup()' >");
     	pw.print("Store pickup</td>");
		pw.print("</td></tr>");
        
		pw.print("<tr><td id='Picpuplocation'  hidden = 'true'>PicpupLocation</td><td><select  id='PicpupLocation'  hidden = 'true' name='pickuplocation' class='input'>" +
				"<option value='l0' name='l0'selected>---select pickup location---</option>" +
				"<option value='l1' name='l1'>Serving the entire Chicago Area, Chicago, IL 60600</option>" +
              "<option value='l2' name='l2'>2233 S Martin Luther King Dr, Chicago, IL 60616</option>" +
              "<option value='l3' name='l3'>2121 S Prairie Ave, Chicago, IL 60616</option>" +
              "<option value='l4' name='l4'>123 E Cermak Rd Suite 100, Chicago, IL 60616</option>" +
              "<option value='l5' name='l5'>21 E Bellevue Pl, Chicago, IL 60611</option>" +
              "<option value='l6' name='l6'>261 1118 N State St, Chicago, IL 60610</option>" +
              "<option value='l7' name='l7'>20 E Delaware Pl, Chicago, IL 60611</option>" +
              "<option value='l8' name='l8'>20 E Chestnut St, Chicago, IL 60611</option>" +
              "<option value='l9' name='l9'>151 E Wacker Dr, Chicago, IL 60601</option>" +
              "<option value='l10' name='l10'>68 E Wacker Pl, Chicago, IL 60601</option>" 
              );
      pw.print("</select></td></tr>");
		
		pw.print("<tr><td colspan='7'>");
		pw.print("<input type='submit' name='submit' class='btnbuy'>");
        pw.print("</td></tr></table></form>");
		pw.print("</div></div></div>");		
		utility.printHtml("Footer.html");
	    }
        catch(Exception e)
		{
         System.out.println(e.getMessage());
		}  			
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	    }
}
