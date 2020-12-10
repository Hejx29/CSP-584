<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Review" %>
<%@ page import="com.mongodb.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>

<!-- Top content -->
<div class="container">
    <div style="text-align: center">
        <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                All reviews<br>
            </h1>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
        </div>
        <%
            HashMap<String, ArrayList<Review>> reviews = new HashMap();
            try {
                // 连接到 mongodb 服务
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                DB db = mongoClient.getDB("homehubReviews");  //连接到数据库
                DBCollection coll = ((DB) db).getCollection("myReviews");  //获取数据库中集合serviceReviews
                System.out.println("Collection Reviews selected successfully");
                DBCursor cursor = coll.find();  //查询集合userInfo中文档信息
                int i = 1;
                while (cursor.hasNext()) {
                    BasicDBObject obj = (BasicDBObject) cursor.next();
                    if (!reviews.containsKey(obj.getString("ProductName"))) {
                        ArrayList<Review> arr = new ArrayList<Review>();
                        reviews.put(obj.getString("ProductName"), arr);
                    }
                    ArrayList<Review> listReview = reviews.get(obj.getString("ProductName"));
                    Review review = new Review(obj.getString("UserID"), obj.getString("ProductName"), obj.getString("ProductType"), obj.getString("TotalPrice"), obj.getString("StoreID"), obj.getString("StoreZip"),
                            obj.getString("StoreCity"), obj.getString("StoreState"), obj.getString("UserAge"), obj.getString("UserGender"), obj.getString("UserOccupation"), obj.getString("ReviewRating"), obj.getString("ReviewDate"), obj.getString("ReviewText"));
                    //add to review hashmap
                    listReview.add(review);
                }

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }

            if (reviews.size() == 0) {

        %>
        <div id="emptycartindent">
            <h2 id="h2">No Reviews!!!</h2>
        </div>
        <%
        } else
            for (String s : reviews.keySet()) {%>
        <h3><%=s%></h3>

        <% for (Review oi : reviews.get(s)) {
        %>

        <table border="1px" width="460px" height="100px" style="margin: auto">
            <tr>
                <td> Product Name:
                </td>
                <td>
                    <%=oi.getProductname() %>
                    <input type='hidden' name='serviceName' value='<%=oi.getProductname() %>'>
                </td>
            </tr>


            <tr>
                <td> Product Type:</td>
                <td>
                    <%=oi.getProducttype() %>
                    <input type='hidden' name='hour' value='<%=oi.getProducttype() %>'>
                </td>
            </tr>


            <tr>
                <td> Total Service Price:</td>
                <td>
                    <%=oi.getPrice() %>
                    <input type='hidden' name='price' value='<%=oi.getPrice() %>'>
                </td>
            </tr>

            <tr>
                <td> Store ID:</td>
                <td>
                    HomeHub Mall
                    <input type='hidden' name='storeID' value='HomeHub'>
                </td>
            </tr>

            <tr>
                <td> Store Zip:</td>
                <td>
                    <%=oi.getStorezip() %>
                    <input type='hidden' type='text' name='storeZip' value='<%=oi.getStorezip() %>'>
                </td>
            </tr>

            <tr>
                <td> Store City:</td>
                <td>
                    <%=oi.getStorecity()%>
                    <input type='hidden' name='storeCity' value='<%=oi.getStorecity()%>'>
                </td>
            </tr>

            <tr>
                <td> Store State:</td>
                <td>
                    <%=oi.getStorestate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getStorestate()%>'>
                </td>
            </tr>

            <tr>
                <td> User Age:</td>
                <td>
                    <%=oi.getUserage()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUserage()%>'>
                </td>
            </tr>
            <tr>
                <td> User Gender:</td>
                <td>
                    <%=oi.getUsergender()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUsergender()%>'>
                </td>
            </tr>
            <tr>
                <td> User Occupation:</td>
                <td>
                    <%=oi.getUserOccupation()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUserOccupation()%>'>
                </td>
            </tr>

            <tr>
                <td> Review Rating:</td>
                <td>
                    <%=oi.getRate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getRate()%>'>
                </td>
            </tr>

            <tr>
                <td> Review Date:</td>
                <td>
                    <%=oi.getReviewDate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getReviewDate()%>'>
                </td>
            </tr>
            <tr>
                <td> Review Text:</td>
                <td>
                    <%=oi.getReviewText()%>
                    <input type='hidden' name='storeState' value='<%=oi.getReviewText()%>'>
                </td>
            </tr>
        </table>
        <br/>
        <%
                    }
                }
        %>
    </div>
</div>


</body>
<br>
<br>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>