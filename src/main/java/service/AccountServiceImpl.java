package service;

import java.util.List;

import Exceptions.InsufficientFundsException;
import Exceptions.SystemException;
import dao.AccountDao;
import dao.AccountDaoCollectionImpl;
import dao.AccountDaoDatabaseImpl;
import model.AccountPojo;

public class AccountServiceImpl implements AccountService{
	
	AccountDao accountDao;
	
	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}

	@Override
	public AccountPojo addAccount(AccountPojo accountPojo) throws SystemException {
		
		return accountDao.addAccount(accountPojo);
	}

	@Override
	public AccountPojo updateAccount(AccountPojo accountPojo) throws SystemException {
		
		return accountDao.updateAccount(accountPojo);
	}

	@Override
	public void deleteAccount(int accountId) throws SystemException {
		accountDao.deleteAccount(accountId);
		
	}

	@Override
	public AccountPojo getAccount(int accountId) throws SystemException {
		return accountDao.getAccount(accountId);
	}

	@Override
	public List<AccountPojo> getAllAccounts() throws SystemException {
		return accountDao.getAllAccounts();
	}

	@Override
	public void transferMoney(int fromAccountId, int toAccountId, double amount) throws InsufficientFundsException {
		accountDao.transferMoney(fromAccountId, toAccountId, amount);
		
	}
	
	

}
