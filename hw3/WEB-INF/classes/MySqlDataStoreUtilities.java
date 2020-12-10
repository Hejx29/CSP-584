import java.sql.*;
import java.util.*;

public class MySqlDataStoreUtilities {
    static Connection conn = null;

    public static void getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "Hjx960729!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    
 //deleteOrder
    public static boolean deleteOrder(int orderId,String productId ) {
        try {

            getConnection();
            String deleteOrderQuery = "Delete from orders where OrderId=? and productId = ?";
            PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
            pst.setInt(1, orderId);
            pst.setString(2, productId);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
   
  //insertOrder

    public static void insertOrder(int orderId, String userName, String productId, double orderPrice, 
    		String fullName, String userAddress, String zipCode, String creditCardNo,String purchaseDate,
    		String shipDate,String category,String quantity,double shippingCost,double discount,String total,String Store_ID,String StoreLocation) {
        try {

            getConnection();

            String insertIntoCustomerOrderQuery = "insert into orders (orderID, userName, productId, orderPrice, "
            		+ "fullName,userAddress,zipCode, creditCardNo,purchaseDate,shipDate,category, quantity,shippingCost,discount,totalsales,Store_ID,StoreLocation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
            //set the parameter for each column and execute the prepared statement
            pst.setInt(1, orderId);
            pst.setString(2, userName);
            pst.setString(3, productId);
            pst.setDouble(4, orderPrice);
            pst.setString(5, fullName);
            pst.setString(6, userAddress);
            pst.setString(7, zipCode);
            pst.setString(8, creditCardNo);
            pst.setString(9, purchaseDate);
            pst.setString(10, shipDate);
            pst.setString(11, category);
            pst.setString(12, quantity);
            pst.setDouble(13, shippingCost);
            pst.setDouble(14, discount);
            pst.setString(15, total);
            pst.setString(16, Store_ID);
            pst.setString(17, StoreLocation);
            
            
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder() {

        HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();

        try {

            getConnection();
            //select the table
            String selectOrderQuery = "select * from orders";
            PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
            ResultSet rs = pst.executeQuery();
            ArrayList<OrderPayment> orderList = new ArrayList<OrderPayment>();
            while (rs.next()) {
                if (!orderPayments.containsKey(rs.getInt("OrderId"))) {
                    ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
                    orderPayments.put(rs.getInt("orderId"), arr);
                }
                ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));
                System.out.println("data is" + rs.getInt("OrderId") + orderPayments.get(rs.getInt("OrderId")));

                //add to orderpayment hashmap
                OrderPayment order = new OrderPayment(rs.getInt("OrderId"), rs.getString("userName"), rs.getString("productId"), rs.getDouble("orderPrice"), rs.getString("fullName"),rs.getString("userAddress"),
                		rs.getString("zipCode"), rs.getString("creditCardNo"),rs.getString("purchaseDate"),rs.getString("shipDate"),rs.getString("category"),rs.getString("quantity"),rs.getDouble("shippingCost"),
                		rs.getDouble("discount"),rs.getString("totalsales"),rs.getString("Store_ID"),rs.getString("StoreLocation"));
                listOrderPayment.add(order);

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return orderPayments;
    }

    public static HashMap<String, StoreAddress> selectStoreAddress() {

        HashMap<String, StoreAddress> storeLocation = new HashMap<String, StoreAddress>();

        try {

            getConnection();
            //select the table
            String selectStoreLocatioQuery = "select * from StoreLocation";
            PreparedStatement pst = conn.prepareStatement(selectStoreLocatioQuery);
            ResultSet rs = pst.executeQuery();
            //ArrayList<StoreAddress> StoreAddressList = new ArrayList<StoreAddress>();
            while (rs.next()) {
                
                //add to orderpayment hashmap
                StoreAddress StoreAddress = new StoreAddress(rs.getString("StoreID"), rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zipCode"));
                storeLocation.put(rs.getString("StoreID"),StoreAddress);

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return storeLocation;
    }
    
    
    
    
// insertUse
    

    public static boolean insertUser(String username, String password, String rePassword, String userType) {
        try {

            getConnection();
            String insertIntoCustomerRegisterQuery = "INSERT INTO user(username,password,repassword,usertype) "
                    + "VALUES (?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, rePassword);
            pst.setString(4, userType);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
    
    public static boolean insertCustomerAddress(String username, String fullName, String Street, String City,String State,String ZipCode) {
        try {

            getConnection();
            String insertIntoCustomerAddressQuery = "INSERT INTO CustomerAddress(userID,CustomerName,Street,City,State,ZipCode) "
                    + "VALUES (?,?,?,?,?,?);";

            PreparedStatement pst = conn.prepareStatement(insertIntoCustomerAddressQuery);
            pst.setString(1, username);
            pst.setString(2, fullName);
            pst.setString(3, Street);
            pst.setString(4, City);
            pst.setString(5, State);
            pst.setString(6, ZipCode);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static HashMap<String, User> selectUser() {
        HashMap<String, User> hm = new HashMap<String, User>();
        try {
            getConnection();
            Statement stmt = conn.createStatement();
            String selectCustomerQuery = "select * from user";
            ResultSet rs = stmt.executeQuery(selectCustomerQuery);
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("usertype"));
                hm.put(rs.getString("username"), user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hm;
    }

    public static void insertProducts() {
        try {

            getConnection();
            String insertProductQuery = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount)" +
                    "VALUES (?,?,?,?,?,?,?,?);";
            for (Map.Entry<String, Accessory> entry : SaxParserDataStore.accessories.entrySet()) {
                String name = "accessories";
                Accessory acc = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, acc.getId());
                pst.setString(3, acc.getName());
                pst.setDouble(4, acc.getPrice());
                pst.setString(5, acc.getImage());
                pst.setString(6, acc.getRetailer());
                pst.setString(7, acc.getCondition());
                pst.setDouble(8, acc.getDiscount());

                pst.executeUpdate();
            }

            for (Map.Entry<String, TV> entry : SaxParserDataStore.tvs.entrySet()) {
                String name = "TV";
                TV tv = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, tv.getId());
                pst.setString(3, tv.getName());
                pst.setDouble(4, tv.getPrice());
                pst.setString(5, tv.getImage());
                pst.setString(6, tv.getRetailer());
                pst.setString(7, tv.getCondition());
                pst.setDouble(8, tv.getDiscount());

                pst.executeUpdate();
                try {
                    HashMap<String, String> acc = tv.getAccessories();
                    String insertAccessoryQuery = "INSERT INTO Product_accessories(productName,accessoriesName)" +
                            "VALUES (?,?);";
                    for (Map.Entry<String, String> accentry : acc.entrySet()) {
                        PreparedStatement pstacc = conn.prepareStatement(insertAccessoryQuery);
                        pstacc.setString(1, tv.getId());
                        pstacc.setString(2, accentry.getValue());
                        pstacc.executeUpdate();
                    }
                } catch (Exception et) {
                    et.printStackTrace();
                }


            }

            for (Map.Entry<String, SoundSystem> entry : SaxParserDataStore.soundsystems.entrySet()) {
                String name = "Soundsystem";
                SoundSystem soundsystem = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, soundsystem.getId());
                pst.setString(3, soundsystem.getName());
                pst.setDouble(4, soundsystem.getPrice());
                pst.setString(5, soundsystem.getImage());
                pst.setString(6, soundsystem.getRetailer());
                pst.setString(7, soundsystem.getCondition());
                pst.setDouble(8, soundsystem.getDiscount());

                pst.executeUpdate();


            }

            for (Map.Entry<String, Laptop> entry : SaxParserDataStore.laptops.entrySet()) {
                String name = "Laptop";
                Laptop laptop = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, laptop.getId());
                pst.setString(3, laptop.getName());
                pst.setDouble(4, laptop.getPrice());
                pst.setString(5, laptop.getImage());
                pst.setString(6, laptop.getRetailer());
                pst.setString(7, laptop.getCondition());
                pst.setDouble(8, laptop.getDiscount());

                pst.executeUpdate();


            }

            for (Map.Entry<String, Voice> entry : SaxParserDataStore.voices.entrySet()) {
                String name = "Voice";
                Voice voice = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, voice.getId());
                pst.setString(3, voice.getName());
                pst.setDouble(4, voice.getPrice());
                pst.setString(5, voice.getImage());
                pst.setString(6, voice.getRetailer());
                pst.setString(7, voice.getCondition());
                pst.setDouble(8, voice.getDiscount());

                pst.executeUpdate();


            }

            for (Map.Entry<String, Phone> entry : SaxParserDataStore.phones.entrySet()) {
                String name = "Phone";
                Phone phone = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, phone.getId());
                pst.setString(3, phone.getName());
                pst.setDouble(4, phone.getPrice());
                pst.setString(5, phone.getImage());
                pst.setString(6, phone.getRetailer());
                pst.setString(7, phone.getCondition());
                pst.setDouble(8, phone.getDiscount());

                pst.executeUpdate();

                
            }

            for (Map.Entry<String, Wearable> entry : SaxParserDataStore.wearables.entrySet()) {
                String name = "Wearable";
                Wearable wearable = entry.getValue();

                PreparedStatement pst = conn.prepareStatement(insertProductQuery);
                pst.setString(1, name);
                pst.setString(2, wearable.getId());
                pst.setString(3, wearable.getName());
                pst.setDouble(4, wearable.getPrice());
                pst.setString(5, wearable.getImage());
                pst.setString(6, wearable.getRetailer());
                pst.setString(7, wearable.getCondition());
                pst.setDouble(8, wearable.getDiscount());

                pst.executeUpdate();


            }

            
           


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, TV> getAccessorys() {
        HashMap<String, TV> hm = new HashMap<String, TV>();
        try {
            getConnection();

            String selectConsole = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectConsole);
            pst.setString(1, "TV");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                TV tv = new TV(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), tv);
                tv.setId(rs.getString("Id"));
                System.out.println(rs.getString("Id"));
                try {
                    String selectaccessory = "Select * from Product_accessories where productName=?";
                    PreparedStatement pstacc = conn.prepareStatement(selectaccessory);
                    pstacc.setString(1, rs.getString("Id"));
                    ResultSet rsacc = pstacc.executeQuery();
                    //System.out.print("assccececeec" + rsacc.getString("accessoriesName"));
                    HashMap<String, String> acchashmap = new HashMap<String, String>();
                    while (rsacc.next()) {
                        if (rsacc.getString("accessoriesName") != null) {
                            System.out.print("acc");
                            acchashmap.put(rsacc.getString("accessoriesName"), rsacc.getString("accessoriesName"));
                            tv.setAccessories(acchashmap);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        }
        return hm;
    }


    public static HashMap<String, TV> getTVs() {
        HashMap<String, TV> hm = new HashMap<String, TV>();
        try {
            getConnection();

            String selectTV = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectTV);
            pst.setString(1, "TV");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	TV tv = new TV(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), tv);
                tv.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, SoundSystem> getSoundSystems() {
        HashMap<String, SoundSystem> hm = new HashMap<String, SoundSystem>();
        try {
            getConnection();

            String selectSoundSystem = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectSoundSystem);
            pst.setString(1, "Soundsystem");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	SoundSystem soundsystem = new SoundSystem(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), soundsystem);
                soundsystem.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, Laptop> getLaptops() {
        HashMap<String, Laptop> hm = new HashMap<String, Laptop>();
        try {
            getConnection();

            String selectLaptop = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectLaptop);
            pst.setString(1, "Laptops");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Laptop laptop = new Laptop(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), laptop);
                laptop.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, Voice> getVoices() {
        HashMap<String, Voice> hm = new HashMap<String, Voice>();
        try {
            getConnection();

            String selectVoice = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectVoice);
            pst.setString(1, "Voices");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Voice voice = new Voice(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), voice);
                voice.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, Wearable> getWearables() {
        HashMap<String, Wearable> hm = new HashMap<String, Wearable>();
        try {
            getConnection();

            String selectSmartWatch = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectSmartWatch);
            pst.setString(1, "Wearables");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Wearable wearable = new Wearable(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), wearable);
                wearable.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }



    public static HashMap<String, Accessory> getAccessories() {
        HashMap<String, Accessory> hm = new HashMap<String, Accessory>();
        try {
            getConnection();

            String selectAcc = "select * from  Productdetails where ProductType=?";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            pst.setString(1, "accessories");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Accessory acc = new Accessory(rs.getString("productName"), rs.getDouble("productPrice"), rs.getString("productImage"), rs.getString("productManufacturer"), rs.getString("productCondition"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), acc);
                acc.setId(rs.getString("Id"));
                //		System.out.println(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static String addproducts(String producttype, String productId, String productName, double productPrice, String productImage, String productManufacturer, String productCondition, double productDiscount, String prod) {
        String msg = "Product is added successfully";
        try {

            getConnection();
            String addProductQurey = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount)" +
                    "VALUES (?,?,?,?,?,?,?,?);";

            String name = producttype;

            PreparedStatement pst = conn.prepareStatement(addProductQurey);
            pst.setString(1, name);
            pst.setString(2, productId);
            pst.setString(3, productName);
            pst.setDouble(4, productPrice);
            pst.setString(5, productImage);
            pst.setString(6, productManufacturer);
            pst.setString(7, productCondition);
            pst.setDouble(8, productDiscount);

            pst.executeUpdate();
            try {
                if (!prod.isEmpty()) {
                    String addaprodacc = "INSERT INTO  Product_accessories(productName,accessoriesName)" +
                            "VALUES (?,?);";
                    PreparedStatement pst1 = conn.prepareStatement(addaprodacc);
                    pst1.setString(1, prod);
                    pst1.setString(2, productId);
                    pst1.executeUpdate();

                }
            } catch (Exception e) {
                msg = "Error while adding the product";
                e.printStackTrace();

            }


        } catch (Exception e) {
            msg = "Error while adding the product";
            e.printStackTrace();

        }
        return msg;
    }

    public static String updateproducts(String producttype, String productId, String productName, double productPrice, String productImage, String productManufacturer, String productCondition, double productDiscount) {
        String msg = "Product is updated successfully";
        try {

            getConnection();
            String updateProductQurey = "UPDATE Productdetails SET productName=?,productPrice=?,productImage=?,productManufacturer=?,productCondition=?,productDiscount=? where Id =?;";


            PreparedStatement pst = conn.prepareStatement(updateProductQurey);

            pst.setString(1, productName);
            pst.setDouble(2, productPrice);
            pst.setString(3, productImage);
            pst.setString(4, productManufacturer);
            pst.setString(5, productCondition);
            pst.setDouble(6, productDiscount);
            pst.setString(7, productId);
            pst.executeUpdate();


        } catch (Exception e) {
            msg = "Product cannot be updated";
            e.printStackTrace();

        }
        return msg;
    }

    public static String deleteproducts(String productId) {
        String msg = "Product is deleted successfully";
        try {

            getConnection();
            String deleteproductsQuery = "Delete from Productdetails where Id=?";
            PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
            pst.setString(1, productId);

            pst.executeUpdate();
        } catch (Exception e) {
            msg = "Proudct cannot be deleted";
        }
        return msg;
    }
    
    public static HashMap<String, Product> selectInventory() {
        HashMap<String, Product> hm = new HashMap<String, Product>();
        try {
            getConnection();

            String selectAcc = "select * from Productdetails";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getString("productName"), rs.getDouble("productPrice"), Integer.parseInt(rs.getString("inventory")));
                hm.put(rs.getString("Id"), product);
                product.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, Product> selectOnSale() {
        HashMap<String, Product> hm = new HashMap<String, Product>();
        try {
            getConnection();

            String selectAcc = "select * from Productdetails where productDiscount > 0";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getString("productName"), rs.getDouble("productDiscount"));
                hm.put(rs.getString("Id"), product);
                product.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    public static HashMap<String, Product> selectRebate() {
        HashMap<String, Product> hm = new HashMap<String, Product>();
        try {
            getConnection();

            String selectAcc = "select * from Productdetails where rebates > 0";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getString("productName"), rs.getDouble("productPrice"), Double.parseDouble(rs.getString("rebates")));
                hm.put(rs.getString("Id"), product);
                product.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }


    public static HashMap<String, OrderPayment> selectSaleAmount() {
        HashMap<String, OrderPayment> hm = new HashMap<String, OrderPayment>();
        try {
            getConnection();

            String selectAcc = "select DISTINCT(temp.productId),temp.saleAmount,temp.counts,orders.orderPrice from exampledatabase.orders, (select productId, sum(totalsales) as saleAmount,sum(quantity) as counts from exampledatabase.orders group by productId) as temp where exampledatabase.orders.productId = exampledatabase.temp.productId;\r\n" + 
            		"";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
                OrderPayment orderPayment = new OrderPayment(rs.getString("productId"), rs.getDouble("orderPrice"), rs.getString("saleAmount"),rs.getInt("counts"));
                i++;
                hm.put(String.valueOf(i), orderPayment);
                //orderPayment.setOrderId(Integer.parseInt(rs.getString("Id")));
            }
        } catch (Exception e) {
        }
        return hm;
    }
    
    public static HashMap<String, OrderPayment> selectDailyTransaction() {
        HashMap<String, OrderPayment> hm = new HashMap<String, OrderPayment>();
        try {
            getConnection();

            String selectAcc = "SELECT sum(totalsales) as tosales, purchaseDate from exampledatabase.orders group by purchaseDate";
            PreparedStatement pst = conn.prepareStatement(selectAcc);
            ResultSet rs = pst.executeQuery();

            int i = 0;
            while (rs.next()) {
                OrderPayment orderPayment = new OrderPayment(rs.getDouble("tosales"), rs.getString("purchaseDate"));
                i++;
                hm.put(String.valueOf(i), orderPayment);
                //orderPayment.setId(rs.getString("Id"));
            }
        } catch (Exception e) {
        }
        return hm;
    }

    
    



}	