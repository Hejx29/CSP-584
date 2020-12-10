import Bean.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AjaxUtility {
    StringBuffer sb = new StringBuffer();
    boolean namesAdded = false;
    static Connection conn = null;
    static String message;

    public static String getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehub?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "12345678");
            message = "Successful";
            return message;
        } catch (Exception e) {
            message = "unsuccessful";
            return message;
        }
    }

    public StringBuffer readdata(String searchId) {
        HashMap<Integer, Product> data;
        data = getData();

        Iterator it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pi = (Map.Entry) it.next();
            if (pi != null) {
                Product p = (Product) pi.getValue();
                if (p.getProductName().toLowerCase().startsWith(searchId)) {
                    sb.append("<product>");
                    sb.append("<id>" + p.getProductId() + "</id>");
                    sb.append("<productName>" + p.getProductName() + "</productName>");
                    sb.append("</product>");
                }
            }
        }

        return sb;
    }

    public static HashMap<Integer, Product> getData() {
        HashMap<Integer, Product> hm = new HashMap<Integer, Product>();
        try {
            getConnection();

            String selectproduct = "select * from Product";
            PreparedStatement pst = conn.prepareStatement(selectproduct);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ProductImage"), rs.getDouble("ProductPrice"), rs.getString("ProductInventory"), rs.getString("ProductStatus"), rs.getString("ProductDescribe"));
                hm.put(rs.getInt("ProductId"), product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hm;
    }

}
