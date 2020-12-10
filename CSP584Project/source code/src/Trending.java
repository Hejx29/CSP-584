

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bestrating;
import Bean.MostSold;
import Bean.Mostsoldzip;
import Bean.Product;

/**
 * Servlet implementation class Trending
 */
@WebServlet("/Trending")
public class Trending extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Bestrating> bestrated = MongoDBDataStoreUtilities.topProducts();
        session.setAttribute("bestrated", bestrated);
        ArrayList <MostSold> mostsold = MongoDBDataStoreUtilities.mostsoldProducts();
        session.setAttribute("mostsold", mostsold);
        ArrayList <Mostsoldzip> mostsoldzip = MongoDBDataStoreUtilities.mostsoldZip();
        session.setAttribute("mostsoldzip", mostsoldzip);
        RequestDispatcher rd = request.getRequestDispatcher("Trending.jsp"); 
    	rd.forward(request, response);
	}

	

}
