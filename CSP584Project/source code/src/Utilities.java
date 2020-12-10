import Bean.CartItem;
import Bean.Product;
import Bean.ServiceOrderItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/* 
	Utilities class contains class variables of type HttpServletRequest, PrintWriter,String and HttpSession.

	Utilities class has a constructor with  HttpServletRequest, PrintWriter variables.
	  
*/

public class Utilities extends HttpServlet {
    HttpServletRequest req;
    PrintWriter pw;
    String url;
    HttpSession session;

    public Utilities() {
    }

    public Utilities(HttpServletRequest req, PrintWriter pw) {
        this.req = req;
        this.pw = pw;
        this.url = this.getFullURL();
        this.session = req.getSession(true);
    }


    public String getFullURL() {
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String contextPath = req.getContextPath();
        StringBuffer url = new StringBuffer();
        url.append(scheme).append("://").append(serverName);

        if ((serverPort != 80) && (serverPort != 443)) {
            url.append(":").append(serverPort);
        }
        url.append(contextPath);
        url.append("/");
        return url.toString();
    }

    /*  HtmlToString - Gets the Html file and Converts into String and returns the String.*/
    public String HtmlToString(String file) {
        String result = null;
        try {
            String webPage = url + file;
            URL url = new URL(webPage);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            result = sb.toString();
        } catch (Exception ignored) {
        }
        return result;
    }

    public void printHtml(String file) {
        String result = HtmlToString(file);
        pw.print(result);
    }

    public String username() {
        if (session.getAttribute("username") != null)
            return session.getAttribute("username").toString();
        return null;
    }

    public void logout() {
        session.removeAttribute("username");
        session.removeAttribute("usertype");
        session.removeAttribute("cart");


    }

    public boolean isLoggedin() {
        return session.getAttribute("username") != null;
    }

    public String ProductID() {
        if (session.getAttribute("productID") != null)
            return session.getAttribute("productID").toString();
        return null;
    }


    public List<Product> select(Product product) {
        //String sql="select * from book ";
        StringBuilder sql = new StringBuilder("select * from book where 1=1 ");
        //sql语句
        List<Object> list = new ArrayList<Object>();
        if (product != null) {

            if (product.getProductId() != 0) {
                sql.append(" and productId=? ");
                list.add(product.getProductId());
            }
        }

        return MySqlDataStoreUtilities.select(sql.toString(), list.toArray());
    }

    public Product getProduct(Product product) {
        if (product.getProductId() != 0) {
            return MySqlDataStoreUtilities.getProduct(product.getProductId());
        }
        return null;
    }
}


