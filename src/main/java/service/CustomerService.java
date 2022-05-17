package service;

import java.util.List;

import Exceptions.NoAccountsException;
import model.CustomerPojo;

public interface CustomerService {
	
	CustomerPojo register(CustomerPojo customerPojo);
	boolean getAllUsers(CustomerPojo valid) throws NoAccountsException;

}
