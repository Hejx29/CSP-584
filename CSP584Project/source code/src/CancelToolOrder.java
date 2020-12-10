import Bean.ToolsOrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CancelToolOrder")
public class CancelToolOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String username = (String) request.getSession().getAttribute("username");
        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        MySqlDataStoreUtilities.deleteToolOrder(orderId);

        List<ToolsOrderItem> toolOrders= MySqlDataStoreUtilities.selectToolOrders(username);
        request.getSession().setAttribute("toolOrders", toolOrders);
        request.setAttribute("msg", "Cancel Successfully!");
        request.getRequestDispatcher("ViewToolOrder.jsp").forward(request, response);
    }
}
