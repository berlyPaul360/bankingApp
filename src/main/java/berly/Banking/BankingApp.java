package berly.Banking;

import java.util.List;
import java.util.Scanner;

import Exceptions.NoAccountsException;
import Exceptions.SystemException;
import model.AccountPojo;
import model.CustomerPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class BankingApp {

	public static void main(String[] args) throws NoAccountsException, SystemException {
		Scanner scan = new Scanner(System.in);
		AccountService accountService = new AccountServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();

		char proceed = 'y';
		String foundUsername;
		while (proceed == 'y') {

			System.out.println("*******************************************");
			System.out.println("BANKING APP SYSTEM");
			System.out.println("*******************************************");
			System.out.println("1.Login");
			System.out.println("2.CREATE ACCOUNT");
			System.out.println("*********************************************");
			System.out.println("Please enter an Option");

			int option = scan.nextInt();
			System.out.println("*********************************************");

			// Outside Switch
			switch (option) {

			// Inside switch to Logon
			case 1:
				//
				List<CustomerPojo> everyCustomer = customerService.getAllUsers();
				CustomerPojo validCustomerPojo = new CustomerPojo();
				
				System.out.println();
				int option1 = 0;
				List<AccountPojo> everyAccount = accountService.getAllAccounts();
				for (int i = 0; i < everyCustomer.size(); i++) {
					// if UserName is found then display the menu
					System.out.println("Please enter your user name");
					validCustomerPojo.setUserName(scan.nextLine());
					if (everyCustomer.get(i).getUserName().equals(validCustomerPojo.getUserName())) {
						
						break;
						
					} else {
						System.out.println("No such User-Name Found");
					}
				}
						System.out.println("*******************************************");
						System.out.println("EMPLOYEE BANKING APPLICATION SYSTEM");
						System.out.println("*******************************************");
						System.out.println("1.List all Accounts");
						System.out.println("2.Transfer Money");
						System.out.println("3.Update Account Info");
						System.out.println("4.Make a Deposit");
						System.out.println("5.EXIT");
						System.out.println("*********************************************");
						System.out.println("Please enter an Option");

						option1 = scan.nextInt();
						System.out.println("*********************************************");
					
										
				
						
				while (proceed == 'y') {
				
					switch (option1) {

					case 1:
						
						System.out.println("*******************************************************************");
						System.out.println("ACCOUNT ID\tACCOUNT NAME\tACCOUNT BALANCE");
						everyAccount.forEach((item) -> System.out.println(
								item.getAccountId() + "\t\t" + item.getName() + "\t" + item.getAccountBalance() + "\t"));
						System.out.println("**********************************************************************");
						System.out.println("Would you like to continue?(y/n)");
						proceed = scan.next().charAt(0);
						break;
					case 2:
						
						
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						System.out.println("Thank you for using Our Banking App!! ");
						System.exit(0);
					}
					//					
					break;
				}
				
			
	//registering a new account/customer			
			case 2:
				AccountPojo newAccountPojo = new AccountPojo();
				CustomerPojo newCustomerPojo = new CustomerPojo();
				System.out.println("******************************");
				System.out.println("ACCOUNT REGISTRATION");
				System.out.println("******************************");
				System.out.println("Please enter your name : ");
				scan.nextLine();
				newAccountPojo.setName(scan.nextLine());
				newCustomerPojo.setCustomer_name(newAccountPojo.getName());
				System.out.println("Please enter the balance that will be deposited : ");
				//scan.nextLine();
				newAccountPojo.setAccountBalance(scan.nextDouble());
				System.out.println("Please enter a new user name : ");
				newCustomerPojo.setUserName(scan.nextLine());
				scan.nextLine();
				System.out.println("Please enter a new password");
				newCustomerPojo.setPassword(scan.nextLine());
				
				AccountPojo accountPojo = null;
				CustomerPojo customerPojo = null;
				try {
					accountPojo = accountService.addAccount(newAccountPojo);
					customerPojo = customerService.register(newCustomerPojo);
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("*************************************");
				System.out.println("New Account added successfully! ");
				break;
			

		}

	}
}
}
