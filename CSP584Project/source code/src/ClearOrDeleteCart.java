import Bean.CartItem;
import Bean.Product;
import Bean.ServiceOrderItem;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ClearOrDeleteCart")
public class ClearOrDeleteCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Utilities utility = new Utilities();
        HttpSession session = request.getSession();
        if (("ClearCart").equals(request.getParameter("ClearCart"))) {
            request.getSession().removeAttribute("cart");
            response.sendRedirect("cart.jsp");
        } else if (("Delete").equals(request.getParameter("Delete"))) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            
            Map<Integer, CartItem> cart = (HashMap) session
                    .getAttribute("cart");
            if (cart.containsKey(productID)) {
                cart.remove(productID);
            }
            response.sendRedirect("cart.jsp");
        }else if("Cancel".equals(request.getParameter("Cancel"))){
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));
            MySqlDataStoreUtilities.deleteServiceOrder(orderId);
            HashMap<String , ArrayList<ServiceOrderItem>> hm = MySqlDataStoreUtilities.selectServiceOrder();

            session.setAttribute("serviceOrder", hm);
            request.setAttribute("msg", "Cancel Successfully!");
            request.getRequestDispatcher("ViewService.jsp").forward(request, response);
        }

    }
}
