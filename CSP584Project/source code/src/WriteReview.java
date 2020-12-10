import Bean.Review;
import Bean.ServiceOrderItem;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/WriteReview")
public class WriteReview extends HttpServlet {
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

        if ("viewReview".equals(request.getParameter("name"))) {
            HashMap<String, ArrayList<Review>> hm = MongoDBDataStoreUtilities.selectReview();
            session.setAttribute("reviews", hm);
            request.getRequestDispatcher("ViewUserReview.jsp").forward(request, response);
            return;
        }

        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String storeID = request.getParameter("storeID");
        String storeZip = request.getParameter("storeZip");
        String storeCity= request.getParameter("storeCity");
        String storeState = request.getParameter("storeState");
        String userID = (String) session.getAttribute("username");
        String userAge = request.getParameter("userAge");
        String userGender = request.getParameter("userGender");
        String userOccupation = request.getParameter("userOccupation");
        String reviewRating = request.getParameter("reviewrating");
        String reviewDate = request.getParameter("reviewDate");
        String reviewText = request.getParameter("reviewText");
        String type = request.getParameter("type");


        String message = MongoDBDataStoreUtilities.insertReview(productName, type, price, storeID, storeZip, storeCity, storeState, userID, userAge, userGender, userOccupation, reviewRating, reviewDate, reviewText);
        request.setAttribute("msg", message);
        request.setAttribute("productName",productName);

        RequestDispatcher rd = request.getRequestDispatcher("SubmitReview.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
