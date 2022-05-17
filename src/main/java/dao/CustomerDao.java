package dao;

import java.sql.SQLException;

import Exceptions.NoAccountsException;
import model.CustomerPojo;

public interface CustomerDao {
	
	CustomerPojo register(CustomerPojo customerPojo);
	CustomerPojo validateUser(CustomerPojo customerPojo) throws NoAccountsException;

}
