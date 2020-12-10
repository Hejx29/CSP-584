import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String username = request.getParameter("customerName");
        String productName = request.getParameter("productName");
        double price = Double.valueOf(request.getParameter("price"));
        String fullname = request.getParameter("fullname");
        String CustomerAddress = request.getParameter("address");
        String zipCode = request.getParameter("zipcode");
        String creditCardNo = request.getParameter("creditCard");
        String purchaseDate = (request.getParameter("purchaseDate"));
        String shippingDate = request.getParameter("shippingDate");
        String itemCatalog = request.getParameter("itemCatalog");
        String count = request.getParameter("count");
        double shippingCost = Double.valueOf(request.getParameter("shippingCost"));
        double discount = Double.valueOf(request.getParameter("discount"));
        String totalsales = String.valueOf(Double.valueOf(count)* Double.valueOf (price));
        String StoreID = request.getParameter("StoreID");
        String StoreLocation = request.getParameter("StoreLocation");
        
        utility.removeOldOrder(orderId, productName);
        //Create a new order id
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        int newOrderId = Integer.parseInt(df.format(new Date()));  
        utility.storeNewOrder(newOrderId, username, productName, price, fullname, CustomerAddress,zipCode, creditCardNo,purchaseDate,shippingDate,itemCatalog,count,shippingCost,discount,totalsales,StoreID,StoreLocation);
        response.sendRedirect("SalesmanHome");
    }
}
