package domain;

public class Product {
	private String productId;
	private String productName;
	private String category;
	private String information;
	
	public Product(){}

	public String getProductId() {
		return productId;
	}
	

	public Product(String productId, String productName, String category, String information) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.information = information;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "PID:" + productId + ", 상품명:" + productName + ", 종류:" + category
				+ ", 정보:" + information;
	}
}
