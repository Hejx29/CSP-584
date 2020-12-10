import com.google.gson.Gson;
//import com.sun.tools.corba.se.idl.constExpr.Or;

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
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat; 
@WebServlet("/SalesReport")
public class SalesReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        displaySalesReport(request, response, pw);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            ArrayList<OrderPayment> orderPaymentArrayList = MySqlDataStoreUtilities.selectDailyTransactionForChart();
//
//            String reviewJson = new Gson().toJson(orderPaymentArrayList);
//
//            System.out.println(reviewJson);
//            response.setContentType("application/JSON");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(reviewJson);
//
//        } catch (Exception ex) {
//
//        }
//    }

    private void displaySalesReport(HttpServletRequest request,
                                    HttpServletResponse response, PrintWriter pw)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");

        HashMap<String, OrderPayment> orderPaymentHashMap = new HashMap<String, OrderPayment>();

        //Table of all product sold
        
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>Table of Product Sold</a>");
        pw.print("</h2><div class='entry'>");

        pw.print("<table class='gridtable'>");
        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("<td>Price</td>");
        pw.print("<td>Sold Amount</td>");
        pw.print("<td>total sales</td>");
        pw.print("</tr>");

        try {
            orderPaymentHashMap = MySqlDataStoreUtilities.selectSaleAmount();
        } catch (Exception ignored) {

        }

        for (OrderPayment orderPayment : orderPaymentHashMap.values()) {

            pw.print("<tr>");
            pw.print("<td>" + orderPayment.getOrderName() + "</td>" +
                    "<td>" + orderPayment.getOrderPrice() + "</td>" + 
            		"<td>" + orderPayment.gettotalcounts() + "</td>"+
            		"<td>" + orderPayment.getSaleAmount() + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div></div>");


        //Bar Chart of that shows the product names and the total sales for every product

        //////////<script>
        pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        pw.println("<script type='text/javascript'>");

        // Load the Visualization API and the corechart package.
        pw.println("google.charts.load('current', {'packages':['corechart']});");

        // Set a callback to run when the Google Visualization API is loaded.
        pw.println("google.charts.setOnLoadCallback(drawChart);");

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        pw.println("function drawChart() {");

        // Create the data table.
        pw.println("var data = new google.visualization.DataTable();");
        pw.println("data.addColumn('string', 'Product Name');");
        pw.println("data.addColumn('number', 'total sales');");
        pw.println(" data.addRows([");
        for (OrderPayment orderPayment : orderPaymentHashMap.values()) {

            pw.println(" ['" + orderPayment.getOrderName() + "', " + orderPayment.getSaleAmount() + "],");
             /*pw.println(" ['Mushrooms', 3],");
              pw.println("['Onions', 1],");n
            pw.println("  ['Olives', 1],");
            pw.println("  ['Zucchini', 1],");
            pw.println("  ['Pepperoni', 2]  ");*/
        }
        pw.println("]);");
        // Set chart options
        pw.println(" var options = {'title':'Sales Report',");
        pw.println("        'width':1000,");
        pw.println("       'height':800};");

        // Instantiate and draw our chart, passing in some options.
        pw.println(" var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
        pw.println("  chart.draw(data, options);     }");
        pw.println(" </script>");


        /////////</script>
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>Bar Chart of Product Sold</a>");
        pw.print("</h2><div class='entry'>");
        pw.println("<div id='chart_div'></div>");
        pw.print("</div></div></div>");



        //Table of total daily sales transactions
        
        pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>Table of Daily Sales Transactions</a>");
        pw.print("</h2><div class='entry'>");

        pw.print("<table class='gridtable'>");
        pw.print("<tr>");
        pw.print("<td>Date</td>");
        pw.print("<td>total sales</td>");
        pw.print("</tr>");

        try {
            orderPaymentHashMap = MySqlDataStoreUtilities.selectDailyTransaction();
        } catch (Exception ignored) {

        }

        for (OrderPayment orderPayment : orderPaymentHashMap.values()) {

            String orderTime = orderPayment.getpurchaseDate();
            DecimalFormat df = new DecimalFormat( "0.00");
            pw.print("<tr>");
            pw.print("<td>" + orderTime + "</td>" +
                    "<td>" + df.format(orderPayment.gettosales()) + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div></div>");
    }
}
