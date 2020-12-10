import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateProduct")
//This servlet is only include function of updating product
public class UpdateProduct extends HttpServlet {
	
    private String error_msg; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        

        int productId = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        String price = request.getParameter("productPrice"); 
        String inventory= request.getParameter("productInventory");
        String image = request.getParameter("productImage");
        String status= request.getParameter("productStatus");
        String describe = request.getParameter("productDescribe");

        if (MySqlDataStoreUtilities.updateProduct(productId, name, price, inventory, image,status,describe)) {
        	error_msg = "Product is updated successfully";
        	request.setAttribute("updateProductMsg", error_msg);
        	RequestDispatcher rd = request.getRequestDispatcher("updateProductSuccess.jsp"); 
        	rd.forward(request, response);
            
        	
        }

    }
}

