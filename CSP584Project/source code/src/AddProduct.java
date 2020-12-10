import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private String error_msg;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Utilities utility = new Utilities(request, pw);


        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String image = request.getParameter("image");
        String inventory = request.getParameter("productInventory");
        String describe = request.getParameter("productDescribe");

        if (MySqlDataStoreUtilities.addProduct(productId, productName, productPrice,image,inventory,describe)){
        	error_msg = "add product successful!";
        }
        request.setAttribute("addProductMsg", error_msg);
        request.getRequestDispatcher("add product.jsp").forward(request, response);

    }
       
}
