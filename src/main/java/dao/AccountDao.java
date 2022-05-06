package dao;

import java.util.List;

import model.AccountPojo;

public interface AccountDao {
	
	//CRUD Operations
	
	AccountPojo addAccount(AccountPojo accountPojo);//Create
	
	AccountPojo updateAccount(AccountPojo accountPojo);//Update
	
	void deleteAccount(int accountId);//Delete
	
	AccountPojo getAccount(int accountId);//Read
	
	List<AccountPojo> getAllAccounts(int accountId);//Read
	
	
	

}
