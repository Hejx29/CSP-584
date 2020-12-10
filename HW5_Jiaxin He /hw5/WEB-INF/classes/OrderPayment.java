import java.io.IOException;
import java.util.Date;
import java.io.*;


/* 
	OrderPayment class contains class variables username,ordername,price,image,address,creditcardno.

	OrderPayment  class has a constructor with Arguments username,ordername,price,image,address,creditcardno
	  
	OrderPayment  class contains getters and setters for username,ordername,price,image,address,creditcardno
*/

public class OrderPayment implements Serializable{
	private int orderId;
	private String userName;
	private String orderName;
	private double orderPrice;
	private String fullName;
	private String userAddress;
	private String zipCode;
	private String creditCardNo;
	private String purchaseDate; 
	private String shippingDate; 
	private String itemCatalog; 
	private String count; 
	private double shippingCost; 
	private double discount;
	private String totalsales; 
	private String StoreID;
	private String StoreLocation;
	private String saleAmount;
    private Date orderTime;
    private int totalcounts;
    private double tosales;
	
	public OrderPayment(int orderId,String userName,String orderName,double orderPrice,
			String fullName,String userAddress,String zipCode,String creditCardNo,String purchaseDate,String shippingDate,String itemCatalog,
			String count,double shippingCost,double discount,String totalsales,String StoreID,String StoreLocation){
		this.orderId=orderId;
		this.userName=userName;
		this.orderName=orderName;
	 	this.orderPrice=orderPrice;
	 	this.fullName = fullName;
		this.userAddress=userAddress;
		this.zipCode=zipCode;
	 	this.creditCardNo=creditCardNo;
	 	this.purchaseDate = purchaseDate;
	 	this.shippingDate = shippingDate;
	 	this.itemCatalog = itemCatalog;
	 	this.count = count;
	 	this.shippingCost  =shippingCost;
	 	this.discount = discount;
	 	this.totalsales = totalsales;
	 	this.StoreID = StoreID;
	 	this.StoreLocation = StoreLocation;
	 	this.tosales = tosales;
	 	
		}
	public OrderPayment(int orderId, String orderName, double orderPrice, String saleAmount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.saleAmount = saleAmount;
    }

    public OrderPayment(String orderName, double orderPrice, String saleAmount,int totalcounts) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.saleAmount = saleAmount;
        this.totalcounts = totalcounts;
    }

    public OrderPayment(double tosales, String purchaseDate) {
    	this.tosales = tosales;
        this.purchaseDate = purchaseDate;
    }

    public double gettosales() {
		return tosales;
	}
	
	public void settosales(double tosales) {
		this.tosales = tosales;
	}
    
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(String saleAmount) {
        this.saleAmount = saleAmount;
    }
	
	public String getStoreLocation() {
		return StoreLocation;
	}
	
	public void setStoreLocation(String StoreLocation) {
		this.StoreLocation = StoreLocation;
	}
	
	public String getStoreID() {
		return StoreID;
	}
	
	public void setStoreID(String StoreID) {
		this.StoreID = StoreID;
	}
	
	public String gettotalsales() {
		return totalsales;
	}
	
	public void settotalsales(String totalsales) {
		this.totalsales = totalsales;
	}
	
	public int gettotalcounts() {
		return totalcounts;
	}
	
	public void settototalcounts(int totalcounts) {
		this.totalcounts = totalcounts;
	}
	
	public double getdiscount() {
		return shippingCost;
	}
	
	public void setdiscount(double discount) {
		this.discount = discount;
	}
	
	public double getshippingCost() {
		return shippingCost;
	}
	
	public void setshippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	public String getcount() {
		return count;
	}
	
	public void setcount(String count) {
		this.count = count;
	}
	
	public String getitemCatalog() {
		return itemCatalog;
	}
	
	public void setitemCatalog(String itemCatalog) {
		this.itemCatalog = itemCatalog;
	}
	
	public String getshippingDate() {
		return shippingDate;
	}
	
	public void setshippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	
	public String getpurchaseDate() {
		return purchaseDate;
	}
	
	public void setpurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
/////	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
//////
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
//////
	public String getCreditCardNo() {
		return creditCardNo;
	}
	
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	

}
