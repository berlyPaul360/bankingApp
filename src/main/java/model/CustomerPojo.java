package model;

public class CustomerPojo {

	private String userName;
	private String password;
	private String customer_name;
	private int customer_account_id;

	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPojo(String userName, String password, String customer_name, int customer_account_id) {
		this.userName = userName;
		this.password = password;
		this.customer_name = customer_name;
		this.setCustomer_account_id(customer_account_id);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getCustomer_account_id() {
		return customer_account_id;
	}

	public void setCustomer_account_id(int customer_account_id) {
		this.customer_account_id = customer_account_id;
	}

	@Override
	public String toString() {
		return "CustomerPojo [userName=" + userName + ", password=" + password + ", customer_name=" + customer_name
				+ "]";
	}

}
