import Bean.CartItem;
import Bean.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")

public class Cart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession(true);

        Utilities utility = new Utilities(request, pw);

        if (!utility.isLoggedin()) {
            request.setAttribute("msg", "Please Login to add items to cart");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Product product = new Product();


        int productID = Integer.parseInt(request.getParameter("productID"));
        String user = (String) session.getAttribute("username");

        product.setProductId(productID);
        Product products = utility.getProduct(product);
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart == null) {
            //new一个购物车
            cart = new HashMap<>();
        }
        CartItem item = (CartItem) cart.get(products.getProductId());

        if (item == null) {
            //如果购物车中不存在该书籍，那么创建，且数量默认为1
            item = new CartItem();
            //将书籍放到购物车中
            item.setProduct(products);

            item.setUsername(user);
            //将书籍的默认数量为1
            item.setNumber(1);
        } else {
            //如果购物车中以及有该书籍，那么数量加1
            item.setNumber(item.getNumber() + 1);
        }

        //cart.put(productID,item);
        cart.put(productID, item);

        ProductRecommenderUtility productRecommenderUtility = new ProductRecommenderUtility();
        HashMap<String, String> prodRecmMap = productRecommenderUtility.readOutputFile();
        HashMap<String, Product> selectProduct = MySqlDataStoreUtilities.selectProduct();

        session.setAttribute("selectProduct", selectProduct);
        session.setAttribute("prodRecmMap", prodRecmMap);

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
        return;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}


    

