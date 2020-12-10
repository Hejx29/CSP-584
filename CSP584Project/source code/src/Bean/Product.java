package Bean;
/* 
	OrderItem class contains class variables name,price,image,retailer.

	OrderItem  class has a constructor with Arguments name,price,image,retailer.
	  
	OrderItem  class contains getters and setters for name,price,image,retailer.
*/

import java.util.HashMap;

public class Product {
	private int ProductId;
	private String ProductName;
	private String ProductImage;
	private double ProductPrice;
	private String ProductInventory;
	private String ProductStatus;
	private String ProductDescribe;

	public Product() {
	}

	public Product(int ProductId, String productName, String ProductImage, double productPrice) {
		super();
		this.ProductId = ProductId;
		this.ProductName = productName;
		this.ProductImage = ProductImage;
		this.ProductPrice = productPrice;
		
	}

	public Product(int ProductId, String productName, double productPrice,String ProductInventory,String ProductStatus,String ProductDescribe){
		this.ProductId = ProductId;
		this.ProductName = productName;
		this.ProductPrice = productPrice;
		this.ProductInventory = ProductInventory;
		this.ProductStatus = ProductStatus;
		this.ProductDescribe = ProductDescribe;
	}

	public Product(int productId, String productName, String productImage, double productPrice, String productInventory, String productStatus, String productDescribe) {
		ProductId = productId;
		ProductName = productName;
		ProductImage = productImage;
		ProductPrice = productPrice;
		ProductInventory = productInventory;
		ProductStatus = productStatus;
		ProductDescribe = productDescribe;
	}

	public String getProductInventory() {
		return ProductInventory;
	}

	public void setProductInventory(String productInventory) {
		ProductInventory = productInventory;
	}

	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	
	public String getProductImage() {
		return ProductImage;
	}
	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}
	public String getProductStatus() {
		return ProductStatus;
	}

	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}

	public String getProductDescribe() {
		return ProductDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		ProductDescribe = productDescribe;
	}

}
