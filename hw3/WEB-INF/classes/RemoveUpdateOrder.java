import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/RemoveUpdateOrder")
public class RemoveUpdateOrder extends HttpServlet {
    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String username = request.getParameter("username");
        String productName = request.getParameter("orderName");
        String price = request.getParameter("price");
        String fullname = request.getParameter("fullName");
        String address = request.getParameter("address");
        String creditCard = request.getParameter("creditCard");
        String userType = request.getParameter("userType");
        String zipcode = request.getParameter("zipCode");
        String purchaseDate = request.getParameter("purchaseDate");
        String shippingDate = request.getParameter("shippingDate");
        String itemCatalog = request.getParameter("itemCatalog");
        String count = request.getParameter("count");
        double shippingCost = Double.valueOf(request.getParameter("shippingCost"));
        double discount = Double.valueOf(request.getParameter("discount"));
        String totalsales = String.valueOf(Double.valueOf(count)* Double.valueOf (price));
        String StoreID = request.getParameter("StoreID");
        String StoreLocation = request.getParameter("StoreLocation");
        

        if (request.getParameter("Order") != null && request.getParameter("Order").equals("Cancel")) {
            //Cancel Order
            utility.removeOldOrder(orderId, productName);

            if (userType.equals("customer")) {
                response.sendRedirect("Account");
            } else {

                response.sendRedirect("SalesmanHome");
            }

        } else if (request.getParameter("Order") != null && request.getParameter("Order").equals("Update")) {
            //Update Order
        	
            utility.printHtml("Header.html");
            utility.printHtml("LeftNavigationBar.html");

            pw.print("<div id='content'>");
            pw.print("<div class='post'>");
            pw.print("<h3 class='title'>");
            pw.print("Update Order");
            pw.print("</h3>");
            pw.print("<div class='entry'>");


            pw.print("<form action='UpdateOrder' method='post'");
            pw.print("<table style='width:100%'>");

            pw.print("<tr>");
            pw.print("<td><h4>Order ID: " + orderId + "</h4></td>");
            pw.print("</tr>");

            pw.print("<tr>");
            pw.print("<td><h4>Customer Name: " + username + "</h4></td>");
            pw.print("</tr><tr><td>");

            pw.print("<tr>");
            pw.print("<td><h4>Product Name: " + productName + "</h4></td>");
            pw.print("</tr><tr><td>");

            
            pw.print("<h4>Price</h4><td><input type='text' name='price' value='" + price + "' class='input' required></input>");
            pw.print("</td></tr></td><tr><td>");

            pw.print("<h4>StoreLocation</h4></td><td><input type='text' name='itemCatalog' value='" + itemCatalog  + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>FullName</h4><td><input type='text' name='fullname' value='" + fullname + "' class='input' required></input>");
            pw.print("</td></tr></td><tr><td>");
            
            pw.print("<h4>Address</h4><td><input type='text' name='address' value='" + address + "' class='input' required></input>");
            pw.print("</td></tr></td><tr><td>");
            
            pw.print("<h4>ZipCode</h4><td><input type='text' name='address' value='" + zipcode + "' class='input' required></input>");
            pw.print("</td></tr></td><tr><td>");

            pw.print("<h4>Credit Card</h4></td><td><input type='text' name='creditCard' value='" + creditCard + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");

            pw.print("<h4>purchaseDate</h4></td><td><input type='text' name='purchaseDate' value='" + purchaseDate + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>shippingDate</h4></td><td><input type='text' name='shippingDate' value='" + shippingDate + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>count</h4></td><td><input type='text' name='count' value='" + count + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>shippingCost</h4></td><td><input type='text' name='shippingCost' value='" + shippingCost + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>discount</h4></td><td><input type='text' name='discount' value='" + discount  + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>totalsales</h4></td><td><input type='text' name='totalsales' value='" + totalsales  + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>StoreID</h4></td><td><input type='text' name='discount' value='" + StoreID  + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
            
            pw.print("<h4>StoreLocation</h4></td><td><input type='text' name='StoreLocation' value='" + StoreLocation  + "' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
        
            pw.print("<input type='hidden' name='orderId' value='" + orderId + "'>");
            pw.print("<input type='hidden' name='customerName' value='" + username + "'>");
            pw.print("<input type='hidden' name='productName' value='" + productName + "'>");
            pw.print("<input type='hidden' name='price' value='" + price + "'>");
            pw.print("<input type='hidden' name='fullname' value='" + fullname + "'>");
            pw.print("<input type='hidden' name='address' value='" + address + "'>");
            pw.print("<input type='hidden' name='zipcode' value='" + zipcode + "'>");
            pw.print("<input type='hidden' name='creditCard' value='" + creditCard + "'>");
            pw.print("<input type='hidden' name='purchaseDate' value='" + purchaseDate + "'>");
            pw.print("<input type='hidden' name='shippingDate' value='" + shippingDate + "'>");
            pw.print("<input type='hidden' name='count' value='" + count + "'>");
            pw.print("<input type='hidden' name='shippingCost' value='" + shippingCost + "'>");
            pw.print("<input type='hidden' name='discount' value='" + discount + "'>");
            pw.print("<input type='hidden' name='totalsales' value='" + totalsales + "'>");
            pw.print("<input type='hidden' name='StoreID' value='" + StoreID + "'>");
            pw.print("<input type='hidden' name='StoreLocation' value='" + StoreLocation + "'>");
            
            
            

            pw.print("<input type='submit' class='btnbuy' value='Update' style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>");
            pw.print("</td></tr><tr><td></td><td>");
            pw.print("</td></tr></table>");
            pw.print("</form></div></div></div>");
        }
    }
}
