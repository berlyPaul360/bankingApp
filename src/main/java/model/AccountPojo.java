package model;

public class AccountPojo {
	
	private int accountId;
	private double accountBalance;
	private String Name;
	  

	
	public AccountPojo() {
		super();
		
	}

	public AccountPojo(int accountId, double accountBalance, String Name) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.Name = Name;
		;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountId=" + accountId + ", accountBalance=" + accountBalance + ", Name=" + Name + "]";
	}

	
	

}
