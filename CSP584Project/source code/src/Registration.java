import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/Registration")

public class Registration extends HttpServlet {
    private String error_msg;
	/*   Username,Password,Usertype information are Obtained from HttpServletRequest variable and validates whether
		 the User Credential Already Exists or else User Details are Added to the Users HashMap */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request, pw);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String usertype = "customer";
        if (!utility.isLoggedin())
            usertype = request.getParameter("usertype");

        //if password and repassword does not match show error message

        if (!password.equals(repassword)) {
            error_msg = "Passwords doesn't match!";
        } else {
            HashMap<String, User> hm = new HashMap<String, User>();
            try {
                hm = MySqlDataStoreUtilities.selectUser();
                usertype = hm.get(username).getUsertype();

            } catch (Exception e) {

            }

            // if the user already exist show error that already exist

            if (hm.containsKey(username))
                error_msg = "Username already exist as " + usertype;
            else {
				/*create a user object and store details into hashmap
				store the user hashmap into file  */

                User user = new User(username, password, usertype);
                hm.put(username, user);
                if (MySqlDataStoreUtilities.insertUser(username, password, repassword, usertype)) {
                    error_msg = "successful!";
                }
            }
        }
        request.setAttribute("msg", error_msg);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
