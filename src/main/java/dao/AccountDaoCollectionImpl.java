package dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.InsufficientFundsException;
import Exceptions.SystemException;
import dao.AccountDao;
import model.AccountPojo;

public class AccountDaoCollectionImpl implements AccountDao{
	
	List<AccountPojo> allAccounts = new ArrayList<>();
	
	public AccountDaoCollectionImpl() {
		
//		AccountPojo account1 = new AccountPojo(101, 20.00, "berl", "paul");
//		AccountPojo account2 = new AccountPojo(102, 100.00, "Sam", "Wilson");
//		AccountPojo account3 = new AccountPojo(103, 0.00, "Tom", "Cat");
//		allAccounts.add(account1);
//		allAccounts.add(account2);
//		allAccounts.add(account3);
	}

	@Override
	public AccountPojo addAccount(AccountPojo accountPojo) {
		// generates new product ID
		//The new Account Id is the last account plus one
		int accountId = allAccounts.get(allAccounts.size()-1).getAccountId()+1;
		//set the new account pojo
		accountPojo.setAccountId(accountId);
		//all product added to data source 
		allAccounts.add(accountPojo);
		
		return accountPojo;
		
	}


	public AccountPojo updateAccount(AccountPojo accountPojo) {
		for(int i = 0;i< allAccounts.size(); i++) {
			if(allAccounts.get(i).getAccountId()== accountPojo.getAccountId()) {
				allAccounts.set(i, accountPojo);
				break;
			}
		}
		return accountPojo;
	}

	@Override
	public void deleteAccount(int accountId) {
		Iterator<AccountPojo> allAccountItr = allAccounts.iterator();
		
		while(allAccountItr.hasNext()) {
			AccountPojo getAccount = allAccountItr.next();
			if(getAccount.getAccountId()== accountId) {
				allAccounts.remove(getAccount);
			}
		}
		
	}

	@Override
	public AccountPojo getAccount(int accountId) {
		AccountPojo foundAccount = null;
		
		for(int i = 0;i < allAccounts.size(); i++) {	
			if(allAccounts.get(i).getAccountId()== accountId) {
				foundAccount = allAccounts.get(i);
				break;
				
			}
		}
		return foundAccount;
	}

	@Override
	public List<AccountPojo> getAllAccounts() {
		// TODO Auto-generated method stub
		return allAccounts;
	}

	@Override
	public void transferMoney(int fromAccountId, int toAccountId, double amount) throws InsufficientFundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMoney(double deposit, int accountId) throws SystemException {
		// TODO Auto-generated method stub
		
	}
	
	

}
