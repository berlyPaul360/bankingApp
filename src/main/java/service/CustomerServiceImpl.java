package service;

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
	public CustomerPojo validateUser(CustomerPojo customerPojo) throws NoAccountsException {
		return customerDao.validateUser(customerPojo);
	}

}
