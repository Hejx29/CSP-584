import Bean.CartItem;
import Bean.Product;
import Bean.ToolsOrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/ToolOrder")
public class ToolOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession(true);

        Utilities utility = new Utilities(request, pw);
        if (!utility.isLoggedin()) {
            request.setAttribute("msg", "Please Login first!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if ("viewToolOrder".equals(request.getParameter("name"))) {
            String username = (String) request.getSession().getAttribute("username");
            List<ToolsOrderItem> toolOrders= MySqlDataStoreUtilities.selectToolOrders(username);

            session.setAttribute("toolOrders", toolOrders);
            request.getRequestDispatcher("ViewToolOrder.jsp").forward(request, response);
            return;
        }


        String username = (String) request.getSession().getAttribute("username");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = (request.getParameter("zipCode"));
        String creditCardNo = request.getParameter("creditCardNo");
        String deliveryMethod = request.getParameter("deliveryMethod");
        String pickuplocation = request.getParameter("pickuplocation");
        Map<Integer, CartItem> cartMap = (Map<Integer, CartItem>) request.getSession().getAttribute("cart");

        //生成唯一的订单号
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        int buyId = Integer.parseInt(df.format(new Date()));  //设置订单号为当前下单时间的时分秒
        Collection<CartItem> cartItems = cartMap.values();
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            double price = cartItem.getNumber()*product.getProductPrice();
            MySqlDataStoreUtilities.insertToolOrder(username,product.getProductId(),product.getProductName(),fullName,
                    phone,email,zipCode,streetAddress,city,state,String.valueOf(price),creditCardNo,buyId,
                    deliveryMethod,pickuplocation,cartItem.getNumber()
                    );
        }
        request.getSession().setAttribute("cart",null);
        request.setAttribute("orderId", buyId);
        request.getRequestDispatcher("ToolOrderSuccess.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
