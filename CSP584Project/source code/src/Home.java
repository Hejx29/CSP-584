import Bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/Home")

public class Home extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

//		Utilities utility = new Utilities(request,pw);
//		utility.printHtml("home.jsp");
        HttpSession session = request.getSession(true);
        String msg = (String) request.getAttribute("msg");
        session.setAttribute("loginmsg", msg);
        HashMap<String, Product> products = MySqlDataStoreUtilities.getData();
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
