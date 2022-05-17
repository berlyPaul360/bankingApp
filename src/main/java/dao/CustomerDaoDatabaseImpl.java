package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exceptions.NoAccountsException;
import model.CustomerPojo;


public class CustomerDaoDatabaseImpl implements CustomerDao{

	@Override
	public CustomerPojo register(CustomerPojo customerPojo) {
		
		Connection conn = null;
		
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO customer_details(customer_username,customer_password,customer_name)VALUES('"+customerPojo.getUserName()+"','"+customerPojo.getPassword()+"','"+customerPojo.getCustomer_name()+"')";
			int rowsAffected = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
		return customerPojo;
	}

	@Override
	public CustomerPojo validateUser(CustomerPojo customerPojo) throws NoAccountsException{
		Connection conn;
		
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details WHERE customer_account_id="+customerPojo.getCustomer_account_id();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				customerPojo.setUserName(rs.getString(2));
				customerPojo.setCustomer_name(rs.getString(4));
				customerPojo.setCustomer_account_id(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new NoAccountsException();
		}
		return customerPojo;
	}

}
