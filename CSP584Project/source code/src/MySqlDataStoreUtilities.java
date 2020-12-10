import Bean.ContactInfo;
import Bean.Product;
import Bean.Profile;
import Bean.ServiceOrderItem;
import Bean.ToolsOrderItem;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySqlDataStoreUtilities {
    static Connection conn = null;

    public static void getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehub?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, User> selectUser() {
        HashMap<String, User> hm = new HashMap<String, User>();
        try {
            getConnection();
            Statement stmt = conn.createStatement();
            String selectCustomerQuery = "select * from  Registration";
            ResultSet rs = stmt.executeQuery(selectCustomerQuery);
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("usertype"));
                hm.put(rs.getString("username"), user);
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static boolean insertUser(String username, String password, String repassword, String usertype) {
        try {

            getConnection();
            String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,password,repassword,usertype) "
                    + "VALUES (?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, repassword);
            pst.setString(4, usertype);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static HashMap<String, Product> selectProduct() {

        HashMap<String, Product> Products = new HashMap<String, Product>();

        try {

            getConnection();
            //select the table
            String selectProductQuery = "select * from Product";
            PreparedStatement pst = conn.prepareStatement(selectProductQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ProductImage"), rs.getDouble("ProductPrice"), rs.getString("ProductInventory"), rs.getString("ProductStatus"), rs.getString("ProductDescribe"));
                Products.put(rs.getString("ProductName"),product);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Products;
    } 
    
    
    

    public static Product getProduct(Integer id) {
        ResultSet rs;
        try {
            getConnection();
            //select the table
            String sql = "select * from Product where ProductId = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            //第四步执行sql
            rs = pst.executeQuery();
            while (rs.next()) {
                Product products = new Product();
                products.setProductId(rs.getInt("ProductId"));
                products.setProductName(rs.getString("ProductName"));
                products.setProductPrice(rs.getDouble("ProductPrice"));
                products.setProductImage(rs.getString("ProductImage"));
                return products;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> select(String sql, Object[] arr) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            getConnection();
            ps = con.prepareStatement(sql);//第二步：预编译
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    ps.setObject(i + 1, arr[i]);
                }
            }
            //第四步执行sql
            rs = ps.executeQuery();
            List<Product> list = new ArrayList<Product>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductPrice(rs.getDouble("ProductPrice"));
                product.setProductImage(rs.getString("ProductImage"));
                product.setProductInventory(rs.getString("ProductInventory"));

                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean insertServiceOrder(int orderId, String username, String productId, String serviceName, String serviceDetail,
            String date, String time, String firstName, String lastName, String phone, String email, String zip, String street, String city, String state, String serviceHour, String servicePrice, String creditNo) {
			try {
			getConnection();
			String insertIntoCustomerOrderQuery = "INSERT INTO ServiceOrders(orderId,username, productId, " +
			"serviceName,serviceDetail,serviceDate,serviceTime,firstName,lastName,phone, " +
			"email, zip, street, city, state, serviceHour, price, creditNo) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
			//set the parameter for each column and execute the prepared statement
			
			//date and time
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
			java.util.Date d1 = null;
			java.util.Date d2 = null;
			try {
			d1 = formatDate.parse(date);
			d2 = formatTime.parse(time);
			} catch (Exception e) {
			e.printStackTrace();
			}
			java.sql.Date serviceDate = new java.sql.Date(d1.getTime());
			java.sql.Time serviceTime = new java.sql.Time(d2.getTime());
			
			
			pst.setInt(1, orderId);
			pst.setString(2, username);
			pst.setInt(3, Integer.parseInt(productId));
			pst.setString(4, serviceName);
			pst.setString(5, serviceDetail);
			pst.setDate(6, serviceDate);
			pst.setTime(7, serviceTime);
			pst.setString(8, firstName);
			pst.setString(9, lastName);
			pst.setString(10, phone);
			pst.setString(11, email);
			pst.setInt(12, Integer.parseInt(zip));
			pst.setString(13, street);
			pst.setString(14, city);
			pst.setString(15, state);
			pst.setString(16, serviceHour);
			pst.setString(17, servicePrice);
			pst.setString(18, creditNo);
			pst.execute();
			return true;
			} catch (Exception e) {
			e.printStackTrace();
			return false;
			}
     }

    public static HashMap<String, ArrayList<ServiceOrderItem>> selectServiceOrder() {
        HashMap<String , ArrayList<ServiceOrderItem>> orderPayments = new HashMap<String, ArrayList<ServiceOrderItem>>();

        try {

            getConnection();
            //select the table
            String selectOrderQuery = "select * from ServiceOrders";
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            ResultSet rs = pst.executeQuery();
            ArrayList<ServiceOrderItem> orderList = new ArrayList<ServiceOrderItem>();
            while (rs.next()) {
                if (!orderPayments.containsKey(rs.getString("username"))) {
                    ArrayList<ServiceOrderItem> arr = new ArrayList<ServiceOrderItem>();
                    orderPayments.put(rs.getString("username"), arr);
                }
                ArrayList<ServiceOrderItem> listOrderPayment = orderPayments.get(rs.getString("username"));
//
                //add to orderpayment hashmap
                ServiceOrderItem order = new ServiceOrderItem(rs.getInt("orderId"), rs.getString("userName"), rs.getString("productId"), rs.getString("serviceName"), rs.getString("serviceDetail"), rs.getString("serviceDate"), rs.getString("serviceTime"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getString("email"), rs.getString("zip"), rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("serviceHour"), rs.getString("price"),rs.getString("creditNo"));
                listOrderPayment.add(order);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderPayments;
    }

    public static void deleteServiceOrder(int id) {
        try {
            getConnection();
            String deleteOrderQuery = "Delete from ServiceOrders where orderId=?";
            PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> getAllProduct() {
        ResultSet rs;
        ArrayList<Product> productlist = new ArrayList<Product>();
        try {
            getConnection();
            //select the table
            String sql = "select * from Product";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
                Product products = new Product();
                products.setProductId(rs.getInt("ProductId"));
                products.setProductName(rs.getString("ProductName"));
                products.setProductPrice(rs.getDouble("ProductPrice"));
                products.setProductImage(rs.getString("ProductImage"));
                products.setProductInventory(rs.getString("ProductInventory"));
                products.setProductStatus(rs.getString("ProductStatus"));
                products.setProductDescribe(rs.getString("ProductDescribe"));
                productlist.add(products);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productlist;
    }
    
    
    public static ArrayList<ServiceOrderItem> getAllServiceOrder() {
        ResultSet rs;
        ArrayList<ServiceOrderItem> ServiceOrderList = new ArrayList<ServiceOrderItem>();
        try {
            getConnection();
            //select the table
            String sql = "select * from ServiceOrders";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
            	ServiceOrderItem ServiceOrderItems = new ServiceOrderItem();
            	ServiceOrderItems.setOrderId(rs.getInt("orderId"));
            	ServiceOrderItems.setUsername(rs.getString("username"));
            	ServiceOrderItems.setProductId(rs.getString("productId"));
            	ServiceOrderItems.setServiceName(rs.getString("serviceName"));
            	ServiceOrderItems.setServiceDetail(rs.getString("serviceDetail"));
            	ServiceOrderItems.setDate(rs.getString("serviceDate"));
            	ServiceOrderItems.setTime(rs.getString("serviceTime"));
            	ServiceOrderItems.setPrice(rs.getString("price"));
            	ServiceOrderList.add(ServiceOrderItems);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ServiceOrderList;
    }

    
    
    
    
    public static ArrayList<ContactInfo> getAllContactInfo() {
        ResultSet rs;
        ArrayList<ContactInfo> ContactInfolist = new ArrayList<ContactInfo>();
        try {
            getConnection();
            //select the table
            String sql = "select * from ContactInfo";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setContactid(rs.getInt("contactid"));
                contactInfo.setCustomerid(rs.getString("customerid"));
                contactInfo.setCustomername(rs.getString("customername"));
                contactInfo.setCustomeremail(rs.getString("customeremail"));
                contactInfo.setCustomerphone(rs.getString("customerphone"));
                contactInfo.setCustomermessage(rs.getString("customermessage"));
                ContactInfolist.add(contactInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ContactInfolist;
    }

    public static boolean addProduct(int productId, String productName, String productPrice, String image,String inventory,String describe) {
        try {

            getConnection();
            String insertIntoCustomerRegisterQuery = "INSERT INTO Product(ProductId,productName,ProductImage,productPrice,productInventory,productDescribe) "
                    + "VALUES (?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
            pst.setInt(1, productId);
            pst.setString(2, productName);
            pst.setString(3, image);
            pst.setString(4, productPrice);
            pst.setString(5, inventory);
            pst.setString(6, describe);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean addServiceOrder(int orderid, String username,int serviceid, String servicename,String servicedetail,String servicedate,String servicetime
    		,String firstname,String lastname,String phone,String email,int zip,String street,String city,String state,String serviceHour,String price,String creditNo) {
        try {

            getConnection();
            String insertIntoCustomerRegisterQuery = "INSERT INTO ServiceOrders(orderId,username,productId,serviceName,serviceDetail,serviceDate,serviceTime,firstName,lastName,phone,email,zip,street,city,state,serviceHour,price,creditNo) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
            pst.setInt(1, orderid);
            pst.setString(2, username);
            pst.setInt(3, serviceid);
            pst.setString(4, servicename);
            pst.setString(5, servicedetail);
            pst.setString(6, servicedate);
            pst.setString(7, servicetime);
            pst.setString(8, firstname);
            pst.setString(9, lastname);
            pst.setString(10, phone);
            pst.setString(11, email);
            pst.setInt(12, zip);
            pst.setString(13, street);
            pst.setString(14, city);
            pst.setString(15, state);
            pst.setString(16, serviceHour);
            pst.setString(17, price);
            pst.setString(18, creditNo);
            
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean storeContactInfo(int contactid,String customerid,String customername, String customeremail, String customerphone, String customermessage) {
        try {

            getConnection();
            String storeContectInfoQuery = "INSERT INTO ContactInfo(contactid,customerid,customername,customeremail,customerphone,customermessage) "
                    + "VALUES (?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(storeContectInfoQuery);
            pst.setInt(1, contactid);
            pst.setString(2, customerid);
            pst.setString(3, customername);
            pst.setString(4, customeremail);
            pst.setString(5, customerphone);
            pst.setString(6, customermessage);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean removeProduct(int productId) {

        try {

            getConnection();
            String deleteproductsQuery = "Delete from Product where ProductId=?";
            PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
            pst.setInt(1, productId);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public static boolean removeServiceOrder(int OrderId) {

        try {

            getConnection();
            String deleteproductsQuery = "Delete from ServiceOrders where orderId=?";
            PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
            pst.setInt(1, OrderId);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateProduct(int productId, String name, String price, String inventory, String image,String status, String describe) {
        try {

            getConnection();
            String updateProductQurey = "UPDATE Product SET ProductName=?,ProductImage=?,ProductPrice=?,ProductInventory=?,ProductStatus=?,ProductDescribe= ? where ProductId =?;";


            PreparedStatement pst = conn.prepareStatement(updateProductQurey);

            pst.setString(1, name);
            pst.setString(2, image);
            pst.setString(3, price);

            pst.setString(4, inventory);
            pst.setString(5, status);
            pst.setString(6, describe);

            pst.setInt(7, productId);

            pst.executeUpdate();


        } catch (Exception e) {
            return false;

        }
        return true;
    }
    
    public static boolean UpdateServiceOrde(int orderId, String productId, String username, String serviceName, String serviceDetail,String serviceDate,String serviceTime,String servicePrice) {
        try {

            getConnection();
            String updateProductQurey = "UPDATE ServiceOrders SET productId=?,username=?,serviceName=?,serviceDetail=?, serviceDate =?, serviceTime = ?,price = ? where orderId =?;";


            PreparedStatement pst = conn.prepareStatement(updateProductQurey);

            pst.setString(1, productId);
            pst.setString(2, username);
            pst.setString(3, serviceName);
            pst.setString(4, serviceDetail);
            pst.setString(5, serviceDate);
            pst.setString(6, serviceTime);
            pst.setString(7, servicePrice);
            pst.setInt(8, orderId);

            pst.executeUpdate();


        } catch (Exception e) {
            return false;

        }
        return true;
    }
    
    public static boolean insertUserProfile(String username,String phone,String email, int zip,String street, String city, String state) {
        try {
            getConnection();
            String insertIntoCustomerOrderQuery = "INSERT INTO UserProfile(username,phone, " +
                    "email, zipCode, street, city, state) "
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            //set the parameter for each column and execute the prepared statement

            pst.setString(1, username);
            pst.setString(2, phone);
            pst.setString(3, email);
            pst.setInt(4, zip);
            pst.setString(5, street);
            pst.setString(6, city);
            pst.setString(7, state);

            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Profile getProfile(String username) {
        ResultSet rs;
        try {
            getConnection();
            //select the table
            String sql = "select * from UserProfile where username = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);

            //第四步执行sql
            rs = pst.executeQuery();
            while (rs.next()) {
                Profile profile = new Profile(rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getInt("zipCode"),rs.getString("phone"),rs.getString("email"));

                return profile;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static ArrayList<Profile> getCustomerInfo() {
        ResultSet rs;
        ArrayList<Profile> Customerlist = new ArrayList<Profile>();
        try {
            getConnection();
            //select the table
            String sql = "select * from UserProfile";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
            	Profile ProfileInfo = new Profile();
            	ProfileInfo.setUsername(rs.getString("username"));
            	ProfileInfo.setStreet(rs.getString("street"));
            	ProfileInfo.setCity(rs.getString("city"));
            	ProfileInfo.setState(rs.getString("state"));
            	ProfileInfo.setZipCode(rs.getInt("zipCode"));
            	ProfileInfo.setPhone(rs.getString("phone"));
            	ProfileInfo.setEmail(rs.getString("email"));
            	Customerlist.add(ProfileInfo);
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return Customerlist;
    }
    public static boolean updateCustomerInfo(String Username, String Street, String City, String State, int ZipCode,String Email,String Phone) {
    	try {
            getConnection();   
            String userProfileQurey = "UPDATE UserProfile SET Street=?,City=?,State=?,ZipCode=?, Email =?, Phone = ? where Username =?;";


            PreparedStatement pst = conn.prepareStatement(userProfileQurey);

            pst.setString(1, Street);
            pst.setString(2, City);
            pst.setString(3, State);
            pst.setInt(4, ZipCode);
            pst.setString(5, Email);
            pst.setString(6, Phone);
            pst.setString(7, Username);

            pst.executeUpdate();


        } catch (Exception e) {
            return false;

        }
        return true;
    }
    
    public static boolean addCustomer(String Username, String Street, String City,String State,int ZipCode,String Email,String Phone) {
        try {

            getConnection();
            String insertIntoCustomerQuery = "INSERT INTO UserProfile(Username,Street,City,State,ZipCode,Email,Phone) "
                    + "VALUES (?,?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerQuery);
            pst.setString(1, Username);
            pst.setString(2, Street);
            pst.setString(3, City);
            pst.setString(4, State);
            pst.setInt(5, ZipCode);
            pst.setString(6, Email);
            pst.setString(7, Phone); 
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public static ArrayList<Product> getNewProduct() {
        ResultSet rs;
        ArrayList<Product> productlist = new ArrayList<Product>();
        try {
            getConnection();
            //select the table
            String sql = "select * from Product where ProductStatus = 'New' ";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
                Product products = new Product();
                products.setProductId(rs.getInt("ProductId"));
                products.setProductName(rs.getString("ProductName"));
                products.setProductPrice(rs.getDouble("ProductPrice"));
                products.setProductImage(rs.getString("ProductImage"));
                products.setProductInventory(rs.getString("ProductInventory"));
                products.setProductDescribe(rs.getString("ProductDescribe"));
                productlist.add(products);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productlist;
    }

    public static ArrayList<Product> getInventory() {
        ResultSet rs;
        ArrayList<Product> productlist = new ArrayList<Product>();
        try {
            getConnection();
            //select the table
            String sql = "select ProductName,ProductPrice,ProductInventory from Product";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
                Product products = new Product();
                products.setProductName(rs.getString("ProductName"));
                products.setProductPrice(rs.getDouble("ProductPrice"));
                products.setProductInventory(rs.getString("ProductInventory"));
                productlist.add(products);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productlist;
    }
    
    public static boolean insertToolOrder(String username, Integer productId, String productName,
            String fullName, String phone, String email, String zip, String street, String city, String state,  String price, String creditNo,
		int buyId,String deliveryMethod,String pickupLocation,int quantity
		) {
		try {
		getConnection();
		String insertIntoCustomerOrderQuery = "INSERT INTO ToolOrders(username, productId, " +
		"productName,fullName,phone, " +
		"email, zip, street, city, state, price, creditNo,buyId,deliveryMethod,pickupLocation,quantity) "
		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
			pst.setString(1, username);
			pst.setInt(2, productId);
			pst.setString(3,productName);
			pst.setString(4, fullName);
			pst.setString(5, phone);
			pst.setString(6, email);
			pst.setString(7, zip);
			pst.setString(8, street);
			pst.setString(9, city);
			pst.setString(10, state);
			pst.setString(11, price);
			pst.setString(12, creditNo);
			pst.setInt(13, buyId);
			pst.setString(14, deliveryMethod);
			pst.setString(15, pickupLocation);
			pst.setInt(16, quantity);
			pst.execute();
			pst.close();
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}

    public static List<ToolsOrderItem> selectToolOrders(String username) {
        try {
            getConnection();
            //select the table
            String selectOrderQuery = "select * from ToolOrders where username = ?";
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            List<ToolsOrderItem> orderList = new ArrayList<>();
            while (rs.next()) {

                ToolsOrderItem order = new ToolsOrderItem(rs.getString("fullName"),
                        rs.getString("productName"), rs.getInt("quantity"),
                        rs.getInt("buyId"), rs.getString("price"), rs.getString("deliveryMethod"), rs.getString("createTime"), rs.getString("zip"), rs.getString("city"), rs.getString("state"));
                order.setOrderId(rs.getInt("orderId"));
                orderList.add(order);
            }
            pst.close();
            return orderList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public static ArrayList<ToolsOrderItem> getAllToolsOrder() {
        ResultSet rs;
        ArrayList<ToolsOrderItem> ToolsOrderList = new ArrayList<ToolsOrderItem>();
        try {
            getConnection();
            //select the table
            String sql = "select * from Toolorders";
            PreparedStatement pst = conn.prepareStatement(sql);

            //第四步执行sql
            rs = pst.executeQuery();

            while (rs.next()) {
            	ToolsOrderItem ToolsOrderItems = new ToolsOrderItem();
            	ToolsOrderItems.setOrderId(rs.getInt("orderId"));
            	ToolsOrderItems.setUsername(rs.getString("username"));
            	ToolsOrderItems.setProductId(rs.getInt("productId"));
            	ToolsOrderItems.setProductName(rs.getString("productName"));
            	ToolsOrderItems.setFullName(rs.getString("fullName"));
            	ToolsOrderItems.setPhone(rs.getString("phone"));
            	ToolsOrderItems.setEmail(rs.getString("email"));
            	ToolsOrderItems.setZip(rs.getString("zip"));
            	ToolsOrderItems.setStreet(rs.getString("street"));
            	ToolsOrderItems.setCity(rs.getString("city"));
            	ToolsOrderItems.setState(rs.getString("state"));
            	ToolsOrderItems.setPrice(rs.getString("price"));
            	ToolsOrderItems.setCreditNo(rs.getString("creditNo"));
            	ToolsOrderItems.setBuyId(rs.getInt("buyId"));
            	ToolsOrderItems.setDeliveryMethod(rs.getString("deliveryMethod"));
            	ToolsOrderItems.setPickupLocation(rs.getString("pickupLocation"));
            	ToolsOrderItems.setQuantity(rs.getInt("quantity"));
            	ToolsOrderItems.setCreateTime(rs.getString("createTime"));
            	ToolsOrderList.add(ToolsOrderItems);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ToolsOrderList;
    }

    public static void deleteToolOrder(Integer orderId) {
		try {
			getConnection();
			String deleteOrderQuery = "Delete from ToolOrders where orderId=?";
			PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				pst.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
}
    public static boolean removeToolsOrder(Integer orderId) {
		try {
			getConnection();
			String deleteOrderQuery = "Delete from ToolOrders where orderId=?";
			PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				pst.close();
				return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
    }
    
    public static boolean AddToolOrder(int orderid,String username, int productId, String productName,
            String fullName, String phone, String email, String zip, String street, String city, String state,  String price, String creditNo,
		int buyId,String deliveryMethod,String pickupLocation,int quantity,String createTime
		) {
		try {
		getConnection();
		String insertIntoCustomerOrderQuery = "INSERT INTO ToolOrders(orderid,username, productId, " +
		"productName,fullName,phone, " +
		"email, zip, street, city, state, price, creditNo,buyId,deliveryMethod,pickupLocation,quantity,createTime) "
		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
			pst.setInt(1, orderid);
			pst.setString(2, username);
			pst.setInt(3, productId);
			pst.setString(4,productName);
			pst.setString(5, fullName);
			pst.setString(6, phone);
			pst.setString(7, email);
			pst.setString(8, zip);
			pst.setString(9, street);
			pst.setString(10, city);
			pst.setString(11, state);
			pst.setString(12, price);
			pst.setString(13, creditNo);
			pst.setInt(14, buyId);
			pst.setString(15, deliveryMethod);
			pst.setString(16, pickupLocation);
			pst.setInt(17, quantity);
			pst.setString(18, createTime);
			pst.execute();
			pst.close();
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}
    public static boolean UpdateToolOrde(int orderId, String FullName, String ProductName, String Price, int Quantity,String City,String State,String Zip) {
        try {

            getConnection();
            String updateProductQurey = "UPDATE ToolOrders SET fullName=?,productName=?,price=?,quantity=?, city =?, state = ?,zip= ? where orderId =?;";


            PreparedStatement pst = conn.prepareStatement(updateProductQurey);

            pst.setString(1, FullName);
            pst.setString(2, ProductName);
            pst.setString(3, Price);
            pst.setInt(4, Quantity);
            pst.setString(5, City);
            pst.setString(6, State);
            pst.setString(7, Zip);
            pst.setInt(8, orderId);

            pst.executeUpdate();


        } catch (Exception e) {
            return false;

        }
        return true;
    }
    
    public static HashMap<String, ServiceOrderItem> selectServiceSaleAmount() {
        HashMap<String, ServiceOrderItem> hm = new HashMap<String, ServiceOrderItem>();
        try {
            getConnection();

            String selectAcc = "select DISTINCT(temp.serviceName),temp.saleAmount,temp.counts,ServiceOrders.price from homehub.ServiceOrders, (select serviceName, sum(price) as saleAmount,sum(serviceHour) as counts from homehub.ServiceOrders group by serviceName) as temp where homehub.ServiceOrders.serviceName = homehub.temp.serviceName";

            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
            	ServiceOrderItem orderPayment = new ServiceOrderItem(rs.getString("serviceName"), rs.getString("price"), rs.getString("saleAmount"),rs.getInt("counts"));
                i++;
                hm.put(String.valueOf(i), orderPayment);
                //orderPayment.setOrderId(Integer.parseInt(rs.getString("Id")));
            }
        } catch (Exception e) {
        }
        return hm;
    }
    public static HashMap<String, ToolsOrderItem> selectToolSaleAmount() {
        HashMap<String, ToolsOrderItem> hm = new HashMap<String, ToolsOrderItem>();
        try {
            getConnection();

            String selectAcc = "select distinct(ToolOrders.ProductName),temp.saleAmount,temp.counts from homehub.ToolOrders, (select ProductName, sum(price) as saleAmount,sum(quantity) as counts from homehub.ToolOrders group by productName) as temp where homehub.ToolOrders.productName = homehub.temp.productName";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
            	ToolsOrderItem ToolOrderPayment = new ToolsOrderItem(rs.getString("productName"), rs.getString("saleAmount"),rs.getInt("counts"));
                i++;
                hm.put(String.valueOf(i), ToolOrderPayment);
                //orderPayment.setOrderId(Integer.parseInt(rs.getString("Id")));
            }
        } catch (Exception e) {
        }
        return hm;
    }
    
    public static HashMap<String, ToolsOrderItem> selectToolTime() {
        HashMap<String, ToolsOrderItem> hm = new HashMap<String, ToolsOrderItem>();
        try {
            getConnection();

            String selectAcc = "select distinct(ToolOrders.createTime),temp.saleAmount from homehub.ToolOrders, (select createTime, sum(price) as saleAmount from homehub.ToolOrders group by createTime) as temp where homehub.ToolOrders.createTime = homehub.temp.createTime\n" + 
            		"";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
            	ToolsOrderItem ToolOrderPayment = new ToolsOrderItem(rs.getString("createTime"), rs.getString("saleAmount"));
                i++;
                hm.put(String.valueOf(i), ToolOrderPayment);
                //orderPayment.setOrderId(Integer.parseInt(rs.getString("Id")));
            }
        } catch (Exception e) {
        }
        return hm;
    }
    public static boolean updateUserProfile(String username, String phone, String email, int zip, String street, String city, String state) {
        try {

            getConnection();
            String updateProductQurey = "UPDATE UserProfile SET phone=?,email=?,zipCode=?,street=?,city= ?,state=? where username =?;";


            PreparedStatement pst = conn.prepareStatement(updateProductQurey);

            pst.setString(1, phone);
            pst.setString(2, email);
            pst.setInt(3, zip);

            pst.setString(4, street);
            pst.setString(5, city);
            pst.setString(6, state);

            pst.setString(7, username);

            pst.executeUpdate();


        } catch (Exception e) {
            return false;

        }
        return true;
    }

    public static void deleteUserProfile(String username) {
        try {
            getConnection();
            String deleteOrderQuery = "Delete from UserProfile where username=?";
            PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
            pst.setString(1, username);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static HashMap<String, Product> getData() {
        HashMap<String, Product> hm = new HashMap<String, Product>();
        try {
            getConnection();
            Statement stmt = conn.createStatement();
            String selectCustomerQuery = "select * from  Product";
            ResultSet rs = stmt.executeQuery(selectCustomerQuery);
            while (rs.next()) {
                Product p = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ProductImage"), rs.getDouble("ProductPrice"), rs.getString("ProductInventory"), rs.getString("ProductStatus"), rs.getString("ProductDescribe"));
                hm.put(rs.getString("ProductName"), p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hm;
    }

}
