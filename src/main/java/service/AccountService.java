package service;



import java.util.List;

import Exceptions.SystemException;
import Exceptions.InsufficientFundsException;
import model.AccountPojo;

public interface AccountService {

//CRUD Operations

	AccountPojo addAccount(AccountPojo accountPojo) throws SystemException;// Create

	AccountPojo updateAccount(AccountPojo accountPojo) throws SystemException;// Update

	void deleteAccount(int accountId) throws SystemException;// Delete

	AccountPojo getAccount(int accountId) throws SystemException;// Read

	List<AccountPojo> getAllAccounts() throws SystemException;// Read
	
	void transferMoney(int fromAccountId, int toAccountId,double amount) throws InsufficientFundsException;

}
