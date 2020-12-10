import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@WebServlet("/Utilities")

/* 
	Utilities class contains class variables of type HttpServletRequest, PrintWriter,String and HttpSession.

	Utilities class has a constructor with  HttpServletRequest, PrintWriter variables.
	  
*/

public class Utilities extends HttpServlet {
    HttpServletRequest req;
    PrintWriter pw;
    String url;
    HttpSession session;

    public Utilities(HttpServletRequest req, PrintWriter pw) {
        this.req = req;
        this.pw = pw;
        this.url = this.getFullURL();
        this.session = req.getSession(true);
    }



	/*  Printhtml Function gets the html file name as function Argument, 
		If the html file name is Header.html then It gets Username from session variables.
		Account ,Cart Information ang Logout Options are Displayed*/

    public void printHtml(String file) {
        String result = HtmlToString(file);
        //to print the right navigation in header of username cart and logout etc
        if (file.equals("Header.html")) {
            result = result + "<div id='menu' style='float: right;font-family:Trebuchet MS'><ul>";
            if (session.getAttribute("username") != null) {
                String username = session.getAttribute("username").toString();
                username = Character.toUpperCase(username.charAt(0)) + username.substring(1);

                String userType = session.getAttribute("usertype").toString();
                switch (userType) {
                    case "customer":
                        result = result + "<li><a><span class='glyphicon'>Hello, " + username + "</span></a></li>"
                                + "<li><a href='Account'><span class='glyphicon'>Account</span></a></li>"
                                + "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
                        break;
                    case "retailer":
										result = result + "<li><a href='StoreManagerHome'><span class='glyphicon'>ViewProduct</span></a></li>"
												 + "<li><a><span class='glyphicon'>Hello, " + username + "</span></a></li>"
												 + "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>"
												 +"<br>"
												 +"<li><a href='Inventory'><span class='glyphicon'>Inventory</span></a></li>"
												 +"<li><a href='SalesReport'><span class='glyphicon'>SalesReport</span></a></li>";
                        break;
                    case "manager":
                        result = result + "<li><a href='SalesmanHome'><span class='glyphicon'>ViewOrder</span></a></li>"
                                + "<li><a><span class='glyphicon'>Hello, " + username + "</span></a></li>"
                                + "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
                        break;
                }
            } else
                result = result + "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>" + "<li><a href='Login'><span class='glyphicon'>Login</span></a></li>";
            result = result + "<li><a href='Cart'><span class='glyphicon'>Cart(" + CartCount() + ")</span></a></li></ul></div></div><div id='page'>";
            pw.print(result);
        } else
            pw.print(result);
    }



    /*  getFullURL Function - Reconstructs the URL user request  */

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
		} 
		catch (Exception e) {
		}
		return result;
	} 

	/*  logout Function removes the username , usertype attributes from the session variable*/

	public void logout(){
		session.removeAttribute("username");
		session.removeAttribute("usertype");
	}
	
	/*  logout Function checks whether the user is loggedIn or Not*/

	public boolean isLoggedin(){
		if (session.getAttribute("username")==null)
			return false;
		return true;
	}

	/*  username Function returns the username from the session variable.*/
	
	public String username(){
		if (session.getAttribute("username")!=null)
			return session.getAttribute("username").toString();
		return null;
	}
	
	/*  usertype Function returns the usertype from the session variable.*/
	public String usertype(){
		if (session.getAttribute("usertype")!=null)
			return session.getAttribute("usertype").toString();
		return null;
	}
	
	/*  getUser Function checks the user is a customer or retailer or manager and returns the user class variable.*/
	public User getUser(){
		String usertype = usertype();
        HashMap<String, User> hm = new HashMap<String, User>();
        hm = MySqlDataStoreUtilities.selectUser();

        return hm.get(username());
	}
	
	/*  getCustomerOrders Function gets  the Orders for the user*/
	public ArrayList<OrderItem> getCustomerOrders(){
		ArrayList<OrderItem> order = new ArrayList<OrderItem>(); 
		if(OrdersHashMap.orders.containsKey(username()))
			order= OrdersHashMap.orders.get(username());
		return order;
	}

	/*  getOrdersPaymentSize Function gets  the size of OrderPayment */
	public int getOrderPaymentSize(){
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();

        orderPayments = MySqlDataStoreUtilities.selectOrder();

        int size = 0;
        for (Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()) {
            size = size + 1;

        }
        return size;		
	}

	/*  CartCount Function gets  the size of User Orders*/
	public int CartCount(){
		if(isLoggedin())
		return getCustomerOrders().size();
		return 0;
	}
	
	/* StoreProduct Function stores the Purchased product in Orders HashMap according to the User Names.*/

	
	public HashMap<String,Integer> ordercount(String name) {
		
		HashMap<String,Integer> ordercount = new HashMap<>();
	    	
	    ordercount.put(name, ordercount.getOrDefault(name, 0)+1);
		
	    return ordercount;
	}
	
	
	
	public void storeProduct(String name,String type,String maker, String acc){
		if(!OrdersHashMap.orders.containsKey(username())){	
			ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
			OrdersHashMap.orders.put(username(), arr);
		}
		ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
		if(type.equals("tvs")){
			TV tv;
			tv = SaxParserDataStore.tvs.get(name);
			OrderItem orderitem = new OrderItem(tv.getName(), tv.getPrice(), tv.getImage(), tv.getRetailer(),tv.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("soundsystems")){
			SoundSystem soundsystem = null;
			soundsystem = SaxParserDataStore.soundsystems.get(name);
			OrderItem orderitem = new OrderItem(soundsystem.getName(), soundsystem.getPrice(), soundsystem.getImage(), soundsystem.getRetailer(),soundsystem.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("phones")){
			Phone phone = null;
			phone = SaxParserDataStore.phones.get(name);
			OrderItem orderitem = new OrderItem(phone.getName(), phone.getPrice(), phone.getImage(), phone.getRetailer(),phone.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("laptops")){
			Laptop laptop = null;
			laptop = SaxParserDataStore.laptops.get(name);
			OrderItem orderitem = new OrderItem(laptop.getName(), laptop.getPrice(), laptop.getImage(), laptop.getRetailer(),laptop.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("voices")){
			Voice voice = null;
			voice = SaxParserDataStore.voices.get(name);
			OrderItem orderitem = new OrderItem(voice.getName(), voice.getPrice(), voice.getImage(), voice.getRetailer(),voice.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("wearables")){
			Wearable wearable = null;
			wearable = SaxParserDataStore.wearables.get(name);
			OrderItem orderitem = new OrderItem(wearable.getName(), wearable.getPrice(), wearable.getImage(), wearable.getRetailer(),wearable.getDiscount());
			orderItems.add(orderitem);
		}
		if(type.equals("accessories")){	
			Accessory accessory = SaxParserDataStore.accessories.get(name); 
			OrderItem orderitem = new OrderItem(accessory.getName(), accessory.getPrice(), accessory.getImage(), accessory.getRetailer(),accessory.getDiscount());
			orderItems.add(orderitem);
		}
		
	}
	
	public void removeItemFromCart(String itemName) {
		ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
		int index = 0;


		for (OrderItem oi : orderItems) {
				if (oi.getName().equals(itemName)) {
						break;
				} else index++;
		}
		orderItems.remove(index);
}

		//OrdersHashMap.orders.values(name);


	public boolean removeProduct(String productId, String catalog) {
	        switch (catalog) {
	            case "tv":
	                SaxParserDataStore.tvs.remove(productId);
	                return true;


	            case "soundsystem":

	                SaxParserDataStore.soundsystems.remove(productId);
	                return true;

	            case "phone":

	                SaxParserDataStore.phones.remove(productId);
	                return true;

	            case "voice":

	                SaxParserDataStore.voices.remove(productId);
	                return true;

	            case "laptop":

	                SaxParserDataStore.laptops.remove(productId);
	                return true;

	            case "wearable":

	                SaxParserDataStore.wearables.remove(productId);
	                return true;
				case "accessory":

	                SaxParserDataStore.accessories.remove(productId);
	                return true;

	        }
	        return false;
	    }
	
	// store the customerAddress
		public void storeCustomerAddress(String username,
			String fullName,String street,String city,String state,String zipCode){
			
			String userName = (String) session.getAttribute("username");

			MySqlDataStoreUtilities.insertCustomerAddress(userName, fullName, street,city,state,zipCode);

		}
	
	// store the payment details for orders
	public void storePayment(int orderId, 
		String orderName,double orderPrice,String 
		fullName,String streetAddress,String zipCode,String creditCardNo,String purchaseDate,
		String shipDate,String category,String count,double shippingCost,double discount,String total,String Store_ID,String StoreLocation){
		
		String userName = (String) session.getAttribute("username");

		MySqlDataStoreUtilities.insertOrder(orderId, userName,orderName, orderPrice, 
				fullName, streetAddress,zipCode, creditCardNo,purchaseDate,
				shipDate,category,count,shippingCost,discount,total,Store_ID,StoreLocation);

	}
	
	//storeNewOrder
	public void storeNewOrder(int orderId, String userName, String orderName, double orderPrice,
			String fullName, String streetAddress,String zipCode, String creditCardNo,String purchaseDate,
			String shipDate,String category,String count,double shippingCost,double discount,String total,String Store_ID,String StoreLocation) {
		MySqlDataStoreUtilities.insertOrder(orderId, userName,orderName, orderPrice, 
				fullName, streetAddress,zipCode, creditCardNo,purchaseDate,
				shipDate,category,count,shippingCost,discount,total,Store_ID,StoreLocation);

    }
	//updateOrder
		public void updateOrder(int orderId, String userName,
	            String orderName, double orderPrice, 
	            String fullName,String streetAddress,String zipCode,String creditCardNo,String purchaseDate,
	            String shipDate,String category,String count,double shippingCost,double discount,String total,String Store_ID,String StoreLocation) {
			MySqlDataStoreUtilities.deleteOrder(orderId,orderName);
	        MySqlDataStoreUtilities.insertOrder(orderId, orderName, userName, orderPrice,
	        		fullName, streetAddress,zipCode, creditCardNo,purchaseDate,
	        		shipDate,category,count,shippingCost,discount,total,Store_ID,StoreLocation);
	    }

	
//Create Products
	public boolean createProduct(String id, String name, String price, String condition, String discount, String image, String type) {
    switch (type) {
        case "tv":
            TV tv = new TV();
            tv.setId(id);
            tv.setName(name);
            tv.setPrice(Double.parseDouble(price));
          //  tv.setRetailer(manufacturer);
            tv.setCondition(condition);
            tv.setDiscount(Double.parseDouble(discount));
            tv.setImage(image);
            SaxParserDataStore.tvs.remove(id);
            SaxParserDataStore.tvs.put(id, tv);

            return true;
        case "soundsystem":

            SoundSystem soundsystem = new SoundSystem();
            soundsystem.setId(id);
            soundsystem.setName(name);
            soundsystem.setPrice(Double.parseDouble(price));
            //soundsystem.setRetailer(manufacturer);
            soundsystem.setCondition(condition);
            soundsystem.setDiscount(Double.parseDouble(discount));
            soundsystem.setImage(image);
            SaxParserDataStore.soundsystems.remove(id);
            SaxParserDataStore.soundsystems.put(id, soundsystem);
            return true;
        
        case "wearable":

            Wearable wearable = new Wearable();
            wearable.setId(id);
            wearable.setName(name);
            wearable.setPrice(Double.parseDouble(price));
          //  wearable.setRetailer(manufacturer);
            wearable.setCondition(condition);
            wearable.setDiscount(Double.parseDouble(discount));
            wearable.setImage(image);
            SaxParserDataStore.wearables.remove(id);
            SaxParserDataStore.wearables.put(id, wearable);
            return true;
            
        case "voice":

            Voice voice = new Voice();
            voice.setId(id);
            voice.setName(name);
            voice.setPrice(Double.parseDouble(price));
          //  voice.setRetailer(manufacturer);
            voice.setCondition(condition);
            voice.setDiscount(Double.parseDouble(discount));
            voice.setImage(image);
            SaxParserDataStore.voices.remove(id);
            SaxParserDataStore.voices.put(id, voice);
            return true;
        case "phone":

            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setPrice(Double.parseDouble(price));
          //  phone.setRetailer(manufacturer);
            phone.setCondition(condition);
            phone.setDiscount(Double.parseDouble(discount));
            phone.setImage(image);
            SaxParserDataStore.phones.remove(id);
            SaxParserDataStore.phones.put(id, phone);
            return true;
        case "laptop":

            Laptop laptop = new Laptop();
            laptop.setId(id);
            laptop.setName(name);
            laptop.setPrice(Double.parseDouble(price));
          //  laptop.setRetailer(manufacturer);
            laptop.setCondition(condition);
            laptop.setDiscount(Double.parseDouble(discount));
            laptop.setImage(image);
            SaxParserDataStore.laptops.remove(id);
            SaxParserDataStore.laptops.put(id, laptop);
            return true;
        

		case "accessory":

			Accessory accessory = new Accessory();
			accessory.setId(id);
			accessory.setName(name);
			accessory.setPrice(Double.parseDouble(price));
			//accessory.setRetailer(manufacturer);
			accessory.setCondition(condition);
			accessory.setDiscount(Double.parseDouble(discount));
			accessory.setImage(image);
			SaxParserDataStore.accessories.remove(id);
			SaxParserDataStore.accessories.put(id, accessory);
			return true;

    }
    return false;
}
//updateProduct
	public boolean updateProduct(String id, String name, String price, String condition, String discount, String image, String type) {
        switch (type) {
        case "tv":
            TV tv = new TV();
            tv.setId(id);
            tv.setName(name);
            tv.setPrice(Double.parseDouble(price));
          //  tv.setRetailer(manufacturer);
            tv.setCondition(condition);
            tv.setDiscount(Double.parseDouble(discount));
            tv.setImage(image);
            SaxParserDataStore.tvs.remove(id);
            SaxParserDataStore.tvs.put(id, tv);

            return true;
        case "soundsystem":

            SoundSystem soundsystem = new SoundSystem();
            soundsystem.setId(id);
            soundsystem.setName(name);
            soundsystem.setPrice(Double.parseDouble(price));
            //soundsystem.setRetailer(manufacturer);
            soundsystem.setCondition(condition);
            soundsystem.setDiscount(Double.parseDouble(discount));
            soundsystem.setImage(image);
            SaxParserDataStore.soundsystems.remove(id);
            SaxParserDataStore.soundsystems.put(id, soundsystem);
            return true;
        
        case "wearable":

            Wearable wearable = new Wearable();
            wearable.setId(id);
            wearable.setName(name);
            wearable.setPrice(Double.parseDouble(price));
          //  wearable.setRetailer(manufacturer);
            wearable.setCondition(condition);
            wearable.setDiscount(Double.parseDouble(discount));
            wearable.setImage(image);
            SaxParserDataStore.wearables.remove(id);
            SaxParserDataStore.wearables.put(id, wearable);
            return true;
            
        case "voice":

            Voice voice = new Voice();
            voice.setId(id);
            voice.setName(name);
            voice.setPrice(Double.parseDouble(price));
          //  voice.setRetailer(manufacturer);
            voice.setCondition(condition);
            voice.setDiscount(Double.parseDouble(discount));
            voice.setImage(image);
            SaxParserDataStore.voices.remove(id);
            SaxParserDataStore.voices.put(id, voice);
            return true;
        case "phone":

            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setPrice(Double.parseDouble(price));
          //  phone.setRetailer(manufacturer);
            phone.setCondition(condition);
            phone.setDiscount(Double.parseDouble(discount));
            phone.setImage(image);
            SaxParserDataStore.phones.remove(id);
            SaxParserDataStore.phones.put(id, phone);
            return true;
        case "laptop":

            Laptop laptop = new Laptop();
            laptop.setId(id);
            laptop.setName(name);
            laptop.setPrice(Double.parseDouble(price));
          //  laptop.setRetailer(manufacturer);
            laptop.setCondition(condition);
            laptop.setDiscount(Double.parseDouble(discount));
            laptop.setImage(image);
            SaxParserDataStore.laptops.remove(id);
            SaxParserDataStore.laptops.put(id, laptop);
            return true;
        

		case "accessory":

			Accessory accessory = new Accessory();
			accessory.setId(id);
			accessory.setName(name);
			accessory.setPrice(Double.parseDouble(price));
			//accessory.setRetailer(manufacturer);
			accessory.setCondition(condition);
			accessory.setDiscount(Double.parseDouble(discount));
			accessory.setImage(image);
			SaxParserDataStore.accessories.remove(id);
			SaxParserDataStore.accessories.put(id, accessory);
			return true;


        }
        return false;
    }

	public boolean isContainsStr(String string) {
    String regex = ".*[a-zA-Z]+.*";
    Matcher m = Pattern.compile(regex).matcher(string);
    return m.matches();
}

	public boolean isItemExist(String itemCatalog, String itemName) {

    HashMap<String, Object> hm = new HashMap<String, Object>();

    switch (itemCatalog) {
        case "tv":
            hm.putAll(SaxParserDataStore.tvs);
            break;
        case "soundsystem":
            hm.putAll(SaxParserDataStore.soundsystems);
            break;
        case "voice":
            hm.putAll(SaxParserDataStore.voices);
            break;
        case "phone":
            hm.putAll(SaxParserDataStore.phones);
            break;
        case "laptop":
            hm.putAll(SaxParserDataStore.laptops);
            break;
        case "wearable":
            hm.putAll(SaxParserDataStore.wearables);
            break;
      case "accessory":
          hm.putAll(SaxParserDataStore.accessories);
          break;
    }
    return true;
}
			
//removeOrder
	public boolean removeOldOrder(int orderId, String orderName) {
		return MySqlDataStoreUtilities.deleteOrder(orderId,orderName);

    }				
				
//updateOrderFile		
	public boolean updateOrderFile(HashMap<Integer, ArrayList<OrderPayment>> orderPayments) {
        String TOMCAT_HOME = System.getProperty("catalina.home");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(TOMCAT_HOME + "/webapps/Tutorial_1/PaymentDetails.txt"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(orderPayments);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {

        }
        return true;
    }
	
	
	
	
	/* getTVs Functions returns the Hashmap with all tvs in the store.*/

	public HashMap<String, TV> getTVs(){
			HashMap<String, TV> hm = new HashMap<String, TV>();
			hm.putAll(SaxParserDataStore.tvs);
			return hm;
	}
	
	/* getSoundSystems Functions returns the  Hashmap with all SoundSystems in the store.*/

	public HashMap<String, SoundSystem> getSoundSystems(){
			HashMap<String, SoundSystem> hm = new HashMap<String, SoundSystem>();
			hm.putAll(SaxParserDataStore.soundsystems);
			return hm;
	}
	
	/* getPhones Functions returns the Hashmap with all Phone in the store.*/

	public HashMap<String, Phone> getPhones(){
			HashMap<String, Phone> hm = new HashMap<String, Phone>();
			hm.putAll(SaxParserDataStore.phones);
			return hm;
	}
	
	/* getPhones Functions returns the Hashmap with all Laptop in the store.*/

	public HashMap<String, Laptop> getLaptops(){
			HashMap<String, Laptop> hm = new HashMap<String, Laptop>();
			hm.putAll(SaxParserDataStore.laptops);
			return hm;
	}
	/* getPhones Functions returns the Hashmap with all Laptop in the store.*/

	public HashMap<String, Voice> getVoices(){
			HashMap<String, Voice> hm = new HashMap<String, Voice>();
			hm.putAll(SaxParserDataStore.voices);
			return hm;
	}
	/* getPhones Functions returns the Hashmap with all Laptop in the store.*/

	public HashMap<String, Wearable> getWearables(){
			HashMap<String, Wearable> hm = new HashMap<String, Wearable>();
			hm.putAll(SaxParserDataStore.wearables);
			return hm;
	}
	/* getPhones Functions returns the Hashmap with all Accessory in the store.*/

	public HashMap<String, Accessory> getAccessory(){
		HashMap<String, Accessory> hm = new HashMap<String, Accessory>();
		hm.putAll(SaxParserDataStore.accessories);
		return hm;
}
	
	
	
	
	/* getProducts Functions returns the Arraylist of tvs in the store.*/

	public ArrayList<String> getProducts(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, TV> entry : getTVs().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	
	/* getProducts Functions returns the Arraylist of soundsystems in the store.*/

	public ArrayList<String> getProductsSoundSystem(){		
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, SoundSystem> entry : getSoundSystems().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	
	/* getProducts Functions returns the Arraylist of Phones in the store.*/

	public ArrayList<String> getProductsPhones(){		
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Phone> entry : getPhones().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	public ArrayList<String> getProductsLaptop(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Laptop> entry : getLaptops().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	public ArrayList<String> getProductsVoice(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Voice> entry : getVoices().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	public ArrayList<String> getProductsWearable(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Wearable> entry : getWearables().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	public ArrayList<String> getProductsaccessory(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Accessory> entry : getAccessory().entrySet()){
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
	
	
	public String storeReview(String productname, String producttype, String productmaker, String reviewrating,
            String reviewdate, String reviewtext, String reatilerpin, String price, String city, String userAge,String Address, String userGender, String userOccupation) {
		String message = MongoDBDataStoreUtilities.insertReview(productname, username(), producttype, productmaker, reviewrating, reviewdate, reviewtext, reatilerpin, price, city, userAge, Address,userGender, userOccupation);
		if (!message.equals("Successful")) {
		return "UnSuccessful";
		} else {
		HashMap<String, ArrayList<Review>> reviews = new HashMap<String, ArrayList<Review>>();
		try {
		reviews = MongoDBDataStoreUtilities.selectReview();
		} catch (Exception e) {
		
		}
		if (reviews == null) {
		reviews = new HashMap<String, ArrayList<Review>>();
		}
		// if there exist product review already add it into same list for productname or create a new record with product name
		
		if (!reviews.containsKey(productname)) {
		ArrayList<Review> arr = new ArrayList<Review>();
		reviews.put(productname, arr);
		}
		ArrayList<Review> listReview = reviews.get(productname);
		Review review = new Review(productname, username(), producttype, productmaker, reviewrating, reviewdate, reviewtext, reatilerpin, price, city, userAge, Address, userGender, userOccupation);
		listReview.add(review);
		
		// add Reviews into database
		
		return "Successful";
		}
		}
	


}
