package service;

import java.util.List;

import Exceptions.NoAccountsException;
import dao.CustomerDao;
import dao.CustomerDaoDatabaseImpl;
import model.CustomerPojo;


public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao customerDao;

	public CustomerServiceImpl() {
		customerDao = new CustomerDaoDatabaseImpl();
	}

	@Override
	public CustomerPojo register(CustomerPojo customerPojo) {
			return customerDao.register(customerPojo);
	}

	@Override
  public boolean getAllUsers(CustomerPojo valid) throws NoAccountsException {
		return customerDao.getAllUsers(valid);
	}

}
