package service;

import Exceptions.NoAccountsException;
import model.CustomerPojo;

public interface CustomerService {
	
	CustomerPojo register(CustomerPojo customerPojo);
	CustomerPojo validateUser(CustomerPojo customerPojo) throws NoAccountsException;

}
