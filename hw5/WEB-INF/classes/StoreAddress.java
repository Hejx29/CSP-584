import java.io.IOException;
import java.io.*;


/* 
	OrderPayment class contains class variables username,ordername,price,image,address,creditcardno.

	OrderPayment  class has a constructor with Arguments username,ordername,price,image,address,creditcardno
	  
	OrderPayment  class contains getters and setters for username,ordername,price,image,address,creditcardno
*/

public class StoreAddress implements Serializable{
	private String storeID;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	
	public StoreAddress(String storeID,String street,String city,String state,String zipCode){
		this.storeID = storeID;
		this.street=street;
		this.city = city;
		this.state = state;
		this.zipCode=zipCode;
	 	
		}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
/////	
	public String getStreetAddress() {
		return street;
	}

	public void setStreetAddress(String street) {
		this.street = street;
	}
//////	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
//////
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
//////
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
//////
	

	

	

	 
	

}
