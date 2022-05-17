package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public boolean getAllUsers(CustomerPojo valid) throws NoAccountsException{
		Connection conn;
		List <CustomerPojo> allCustomers = new ArrayList <CustomerPojo>();
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details";
			ResultSet rs = stmt.executeQuery(query);
			int counter =0;
			while(rs.next()) {
				counter++;
				CustomerPojo customerPojo = new CustomerPojo(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(1));
				allCustomers.add(customerPojo);
			}
			if(counter==0) {
				throw new NoAccountsException();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new NoAccountsException();
		}
		
		Iterator<CustomerPojo> allCustomersItr = allCustomers.iterator();
		while(allCustomersItr.hasNext()) {
			CustomerPojo getAccount = allCustomersItr.next();
			if(getAccount.getUserName().equals(valid.getUserName())) {
				
				return true;
			}
			
		}
		return false;
	}

}
