import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and
		password are validated and added to session variable and display Login Function is called */

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("usertype");

        HashMap<String, User> hm = new HashMap<String, User>();
        //user details are validated using a file
        //if the file contains username and password user entered user will be directed to home page
        //else error message will be shown
        try {
            hm = MySqlDataStoreUtilities.selectUser();  //hm存放用户信息

        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = hm.get(username);
        if (user != null) {  //存在该用户名，进行校验
            String user_password = user.getPassword();
            if (password.equals(user_password)) {
                String user_type = user.getUsertype();
                if(userType.equals(user_type)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    session.setAttribute("userType", userType);
                    if (userType.equalsIgnoreCase("Customer")) {
                        response.sendRedirect("Home");
                        return;
                    } else if (userType.equalsIgnoreCase("retailer")) {
                        response.sendRedirect("StoreManagerHome.jsp");
                        return;
                    }
                }else{
                	HttpSession session = request.getSession(true);
                	session.setAttribute("loginmsg", "Please check your user type!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }else{
            	HttpSession session = request.getSession(true);
            	session.setAttribute("loginmsg", "Please check your username and password!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
        //用户名不存在
        else {
            request.setAttribute("msg", "Please check your username and password!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
