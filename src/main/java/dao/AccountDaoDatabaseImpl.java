package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InsufficientFundsException;
import Exceptions.SystemException;
import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao{

	@Override
	public AccountPojo addAccount(AccountPojo accountPojo) throws SystemException {
		Connection conn = null;
		
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO account_details(account_balance,account_name) VALUES ('"+accountPojo.getAccountBalance()+"','"+accountPojo.getName()+"')";
			int rowsAffected = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SystemException();
		}
		
		
		return accountPojo;
	}

	@Override
	public void addMoney(double deposit, int accountId) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE account_details SET account_balance=account_balance+"+deposit+ "WHERE account_id="+accountId;
			int rowsAffected = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new SystemException();
		}
		
		System.out.println("DEPOSIT MADE ");
		
	}

	@Override
	public void deleteAccount(int accountId) throws SystemException {
		
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "DELETE FROM account_details WHERE account_id="+accountId;
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new SystemException();
		}
		
	}

	@Override
	public AccountPojo getAccount(int accountId) throws SystemException {
		
		Connection conn = null;
		AccountPojo accountPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT FROM account_details WHERE account_id="+accountId;
			ResultSet result = stmt.executeQuery(query);
			if(result.next()) {
				accountPojo = new AccountPojo(result.getInt(1),result.getDouble(2),result.getString(3));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public List<AccountPojo> getAllAccounts() throws SystemException {
		
		Connection conn = null;
		AccountPojo accountPojo = null;
		List <AccountPojo> allAccounts= new ArrayList<>();  
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM account_details";
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				accountPojo = new AccountPojo(result.getInt(1),result.getDouble(2),result.getString(3));
				allAccounts.add(accountPojo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SystemException();
		}
		return allAccounts;
		
	}

	@Override
	public void transferMoney(int fromAccountId, int toAccountId, double amount) throws InsufficientFundsException{
		Connection conn = null;
		
		try {
			conn = DBUtil.makeConnection();
			CallableStatement cstmt = conn.prepareCall("call transfer_money(?,?,?)");
			cstmt.setInt(1, fromAccountId);
			cstmt.setInt(2, toAccountId);
			cstmt.setDouble(3, amount);
			cstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Transfer Performed");
	}
	
	
	

}
