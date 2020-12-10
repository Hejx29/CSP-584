package Bean;

public class ContactInfo {
	private int contactid;
	private String customerid;
	private String customername;
	private String customeremail;
	private String customerphone;
	private String customermessage;
	public ContactInfo(int contactid, String customerid, String customername, String customeremail,
			String customerphone, String customermessage) {
		super();
		this.contactid = contactid;
		this.customerid = customerid;
		this.customername = customername;
		this.customeremail = customeremail;
		this.customerphone = customerphone;
		this.customermessage = customermessage;
	}
	public ContactInfo() {
	}
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getCustomermessage() {
		return customermessage;
	}
	public void setCustomermessage(String customermessage) {
		this.customermessage = customermessage;
	}

}

