package dao;

import java.sql.SQLException;
import java.util.List;

import Exceptions.NoAccountsException;
import model.CustomerPojo;

public interface CustomerDao {
	
	CustomerPojo register(CustomerPojo customerPojo);
	boolean getAllUsers(CustomerPojo valid) throws NoAccountsException;

}
