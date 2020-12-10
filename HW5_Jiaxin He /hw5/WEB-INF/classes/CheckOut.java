import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		int count = 0;
		HashMap<String,Integer> ordercount = new HashMap<>();
	 
		
			for (OrderItem oi : utility.getCustomerOrders()) 
			{	
				
				ordercount.put(oi.getName(), ordercount.getOrDefault(oi.getName(), 0)+1);
				pw.print("<tr><td> Product Purchased:</td><td>");
				pw.print(oi.getName()+"</td></tr><tr><td>");
				pw.print("<input type='hidden' name='orderPrice' value='"+oi.getPrice()+"'>");
				pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+ "'+>");
				pw.print("Product Price:</td><td>"+ oi.getPrice());
				pw.print("</td></tr>");
			
		}
			session.setAttribute("quantity",ordercount);
		
		pw.print("<tr><td>");
        pw.print("Total Order Cost</td><td>"+orderTotal);
		pw.print("<input type='hidden' name='orderTotal' value='"+orderTotal+"'>");
		pw.print("</td></tr></table><table><tr></tr><tr></tr>");	
		
		pw.print("<tr><td>");
	    pw.print("Full Name</td>");
		pw.print("<td><input type='text' name='fullName'>");
        pw.print("</td></tr>");
		
		pw.print("<tr><td>");
	    pw.print("street</td>");
		pw.print("<td><input type='text' name='streetAddress'>");
        pw.print("</td></tr>");
        
        pw.print("<tr><td>");
	    pw.print("city</td>");
		pw.print("<td><input type='text' name='city'>");
        pw.print("</td></tr>");
        
        pw.print("<tr><td>");
	    pw.print("state</td>");
		pw.print("<td><input type='text' name='state'>");
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
			  "<option value='Apple Michigan Avenue' name='l1'>Apple Michigan Avenue,401 N Michigan Ave,Chicago,IL ,60611</option>" +
              "<option value='b8ta' name='l2'>b8ta,520 Michigan Ave,Chicago,IL,60611</option>" +
              "<option value='Dynamite' name='l3'>Dynamite,207 E Ohio St,Chicago,IL,60611</option>" +
              "<option value='Jalisco' name='l4'>Jalisco,1933 W Chicago Ave,Chicago,IL,60622</option>" +
              "<option value='Jre & Associates Inc' name='l5'>Jre & Associates Inc,215 E 31st St,Chicago,IL,60616 </option>" +
              "<option value='Magnolia' name='l6'>Magnolia,555 W Roosevelt Rd,Chicago,IL,60607</option>"+
              "<option value='Nyce' name='l7'>Nyce,227 W Monroe St STE 1800,Chicago,IL,60606 </option>" +
              "<option value='Micro Center' name='l8'>Micro Center,2645 N Elston Ave,Chicago,IL,60647</option>" +
              "<option value='Ricoh USA' name='l9'>Ricoh USA,180 N Wabash Ave # 700,Chicago,IL,60601 </option>" +
              "<option value='U & I' name='l10'>U & I,646 E 43rd St,Chicago,IL,60653</option>" 
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
