
import Bean.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewCustomer")

public class viewCustomer extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        doPost(request, response);
        HttpSession session = request.getSession(true);
        ArrayList<Profile> Customerlist = MySqlDataStoreUtilities.getCustomerInfo();
        session.setAttribute("Customerlist", Customerlist);
        response.sendRedirect("view customer.jsp");
}
    
}












    



