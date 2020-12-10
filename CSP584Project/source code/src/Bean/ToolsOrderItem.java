package Bean;

public class ToolsOrderItem {
   
    private int orderId;
    private String username;
    private int productId;
    private String productName;
    private String fullName;
    private String phone;
    private String email;
    private String zip;
    private String street;
    private String city;
    private String state;
    private String hour;
    private String price;
    private String creditNo;
    private int buyId;
    private String pickupLocation;
    private String deliveryMethod;
    private int quantity;
    private String createTime;
    private String saleAmount;
    private int  counts;

    
    

	public String getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public ToolsOrderItem(int orderId, String username, int productId, String productName, String fullName,
			String phone, String email, String zip, String street, String city, String state, String hour, String price,
			String creditNo, int buyId, String pickupLocation, String deliveryMethod, int quantity, String createTime) {
		super();
		this.orderId = orderId;
		this.username = username;
		this.productId = productId;
		this.productName = productName;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.zip = zip;
		this.street = street;
		this.city = city;
		this.state = state;
		this.hour = hour;
		this.price = price;
		this.creditNo = creditNo;
		this.buyId = buyId;
		this.pickupLocation = pickupLocation;
		this.deliveryMethod = deliveryMethod;
		this.quantity = quantity;
		this.createTime = createTime;
	}

	public ToolsOrderItem() {
    	
    }
    
    public ToolsOrderItem(String fullName, String productName, int quantity, int buyId, String price, String deliveryMethod, String createTime) {
        this.fullName = fullName;
        this.productName = productName;
        this.quantity = quantity;
        this.buyId = buyId;
        this.price = price;
        this.deliveryMethod = deliveryMethod;
        this.createTime = createTime;
    }

    

	public ToolsOrderItem( String fullName,String productName, int quantity,int buyId,String price,String deliveryMethod,String createTime,String zip, String city, String state 
			  ) {
		super();
		
		this.fullName = fullName;
		this.productName = productName;
		this.quantity = quantity;
		this.zip = zip;
		this.street = street;
		this.city = city;
		this.state = state;
		this.buyId = buyId;
		this.price = price;
		this.deliveryMethod = deliveryMethod;
		
		this.createTime = createTime;
	}

	

	public ToolsOrderItem(String productName, String saleAmount, int counts) {
		this.productName = productName;
		this.saleAmount = saleAmount;
		this.counts = counts;
		

	}
	
	public ToolsOrderItem(String createTime, String saleAmount) {
		this.createTime = createTime;
		this.saleAmount = saleAmount;
		
		

	}

	public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBuyId() {
        return buyId;
    }

    public void setBuyId(int buyId) {
        this.buyId = buyId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
}
