import Bean.CartItem;
import Bean.Product;
import Bean.ServiceOrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ServiceOrder")

public class ServiceOrder extends HttpServlet {
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

        if ("viewService".equals(request.getParameter("name"))) {
            HashMap<String, ArrayList<ServiceOrderItem>> hm = MySqlDataStoreUtilities.selectServiceOrder();

            session.setAttribute("serviceOrder", hm);
            request.getRequestDispatcher("ViewService.jsp").forward(request, response);
            return;
        }


        String username = (String) session.getAttribute("username");
        String productId = request.getParameter("productID");
        String serviceName = request.getParameter("serviceName");
        String detail = request.getParameter("detail");
        String serviceDate = request.getParameter("serviceDate");
        String serviceTime = request.getParameter("serviceTime");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String zipCode = request.getParameter("zipCode");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String serviceHour = request.getParameter("hour");
        String servicePrice = request.getParameter("price");
        String creditNo = request.getParameter("creditNo");


        //生成唯一的订单号
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        int orderId = Integer.parseInt(df.format(new Date()));  //设置订单号为当前下单时间的时分秒
        System.out.println(serviceTime);

        if (MySqlDataStoreUtilities.insertServiceOrder(orderId, username, productId, serviceName, detail, serviceDate, serviceTime, firstName, lastName, phone, email, zipCode, street, city, state, serviceHour, servicePrice, creditNo)) {
            HashMap<String, ArrayList<ServiceOrderItem>> hm = MySqlDataStoreUtilities.selectServiceOrder();

            request.setAttribute("orderId", orderId);
            session.setAttribute("serviceOrder", hm);
            if ("Book".equals(request.getParameter("bookService"))) {
                request.getRequestDispatcher("Payment.jsp").forward(request, response);
                return;
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}


    

