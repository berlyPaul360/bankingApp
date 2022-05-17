package dao;

import java.sql.SQLException;
import java.util.List;

import Exceptions.InsufficientFundsException;
import Exceptions.SystemException;
import model.AccountPojo;

public interface AccountDao {
	
	//CRUD Operations
	
	AccountPojo addAccount(AccountPojo accountPojo) throws SystemException;//Create
	
	AccountPojo updateAccount(AccountPojo accountPojo) throws SystemException;//Update
	
	void deleteAccount(int accountId)throws SystemException;//Delete
	
	AccountPojo getAccount(int accountId)throws SystemException;//Read
	
	List<AccountPojo> getAllAccounts()throws SystemException;//Read
	
	void transferMoney(int fromAccountId, int toAccountId,double amount)throws InsufficientFundsException;
	
	
	

}
