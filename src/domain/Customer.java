package domain;

public class Customer {
	private String id;
	private String passwd;
	private String name;
	private int age;
	private String address;

	public Customer() {}

	
	public Customer(String id, String passwd, String name, int age, String address) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
		this.address = address;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", 이름: " + name + ", 나이: " + age + ", 주소: " + address;
	}
	
	
}
