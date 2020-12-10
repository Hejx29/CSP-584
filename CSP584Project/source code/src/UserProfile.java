import Bean.Profile;
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

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {

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

        String username = (String) session.getAttribute("username");

        if ("createProfile".equals(request.getParameter("name"))) {
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            int zipCode = Integer.parseInt(request.getParameter("zipCode"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            if (MySqlDataStoreUtilities.insertUserProfile(username, phone, email, zipCode, street, city, state)) {
                Profile profile2 = MySqlDataStoreUtilities.getProfile(username);
                request.setAttribute("msg", "create successful!");
                session.setAttribute("profile", profile2);
                request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("msg", "error! Please check your information, try again~");
                request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
            }
        } else if ("updateProfile".equals(request.getParameter("name"))) {
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            int zipCode = Integer.parseInt(request.getParameter("zipCode"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            if (MySqlDataStoreUtilities.updateUserProfile(username, phone, email, zipCode, street, city, state)) {
                Profile profile2 = MySqlDataStoreUtilities.getProfile(username);
                request.setAttribute("msg", "update successful!");
                session.setAttribute("profile", profile2);
                request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
                return;
            }
        } else if ("delete".equals(request.getParameter("delete"))) {
            MySqlDataStoreUtilities.deleteUserProfile(username);
            request.setAttribute("msg", "deleter successful!");
        }


        Profile profile = MySqlDataStoreUtilities.getProfile(username);

        session.setAttribute("profile", profile);
        request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        return;
        //show page

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);

    }
}
