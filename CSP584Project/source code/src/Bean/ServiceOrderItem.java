package Bean;

import java.sql.Date;
import java.sql.Time;

public class ServiceOrderItem {
    private int orderId;
    private String username;
    private String productId;
    private String serviceName;
    private String serviceDetail;
    private String date;
    private String time;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String zip;
    private String street;
    private String city;
    private String state;
    private String hour;
    private String price;
    private String creditNo;
    private String serviceTotalTime;
    private int counts;

    public ServiceOrderItem() {
    }

    public ServiceOrderItem(int orderId, String username, String productId, String serviceName, String serviceDetail, String date, String time, String firstName, String lastName, String phone, String email, String zip, String street, String city, String state, String hour, String price, String creditNo) {
        this.orderId = orderId;
        this.username = username;
        this.productId = productId;
        this.serviceName = serviceName;
        this.serviceDetail = serviceDetail;
        this.date = date;
        this.time = time;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.zip = zip;
        this.street = street;
        this.city = city;
        this.state = state;
        this.hour = hour;
        this.price = price;
        this.creditNo = creditNo;
    }

    public ServiceOrderItem(int orderId, String username, String productId, String serviceName, String serviceDetail, String date, String time) {
        this.orderId = orderId;
        this.username = username;
        this.productId = productId;
        this.serviceName = serviceName;
        this.serviceDetail = serviceDetail;
        this.date = date;
        this.time = time;
    }

    public ServiceOrderItem(String serviceName, String price, String serviceTotalTime, int counts) {
    	this.serviceName = serviceName;
    	this.serviceTotalTime = serviceTotalTime;
    	this.price = price;
    	this.counts = counts;
	}

	public String getServiceTotalTime() {
		return serviceTotalTime;
	}

	public void setServiceTotalTime(String serviceTotalTime) {
		this.serviceTotalTime = serviceTotalTime;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }
}
