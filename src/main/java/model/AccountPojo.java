package model;

public class AccountPojo {
	
	private int accountId;
	private double accountBalance;
	private String firstName;
	private String lastName;
	
	public AccountPojo() {
		super();
		
	}

	public AccountPojo(int accountId, double accountBalance, String firstName, String lastName) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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

	@Override
	public String toString() {
		return "AccountPojo [accountId=" + accountId + ", accountBalance=" + accountBalance + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
	
	

}
