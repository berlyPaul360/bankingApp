package berly.Banking;

import java.util.List;
import java.util.Scanner;

import Exceptions.InsufficientFundsException;
import Exceptions.NoAccountsException;
import Exceptions.SystemException;
import model.AccountPojo;
import model.CustomerPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;


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
				
				 List<AccountPojo> everyAccount = accountService.getAllAccounts();
				CustomerPojo validCustomerPojo = new CustomerPojo();
				
				System.out.println();
				int option1 = 0;

				System.out.println("Please enter your user name");
				validCustomerPojo.setUserName(scan.nextLine());
				scan.nextLine();
				System.out.println("Please enter your password");
				validCustomerPojo.setPassword(scan.nextLine());
				scan.nextLine();
				System.out.println("Please enter your name");
				validCustomerPojo.setCustomer_name(scan.nextLine());
				///// Validates User-Name//////////////////////////////
				if (customerService.getAllUsers(validCustomerPojo)) {
					
				

						System.out.println("*******************************************");
						System.out.println("EMPLOYEE BANKING APPLICATION SYSTEM");
						System.out.println("*******************************************");
						System.out.println("1.List all Accounts");
						System.out.println("2.Transfer Money");
						System.out.println("3.Make a Deposit");
						System.out.println("4.EXIT");		
						System.out.println("*********************************************");
						System.out.println("Please enter an Option");
	
						option1 = scan.nextInt();
						System.out.println("*********************************************");

					

						switch (option1) {

						case 1:

							System.out.println("*******************************************************************");
							System.out.println("ACCOUNT ID\tACCOUNT NAME\tACCOUNT BALANCE");
							everyAccount.forEach((item) -> System.out.println(item.getAccountId() + "\t\t"
									+ item.getName() + "\t" + item.getAccountBalance() + "\t"));
							System.out
									.println("**********************************************************************");
							System.out.println("Would you like to continue?(y/n)");
							proceed = scan.next().charAt(0);
							break;
						case 2:
							System.out.println("***********************************************************************");
							System.out.println("\t\t\t\t\t\t\t\tACCOUNT TRANSFER ");
							System.out.println("***********************************************************************");
							System.out.println("What is your account ID ");
							int fromAccount = scan.nextInt();
							System.out.println("Please enter the account ID you wish to transfer the money to ");
							int toAccount = scan.nextInt();
							scan.nextLine();
							System.out.println("Please enter the amount you wish to transfer : ");
							double amount = scan.nextDouble();
							
							try {
								accountService.transferMoney(fromAccount, toAccount, amount);
								
								
							} catch (InsufficientFundsException e) {
								e.getMessage();
							}
							System.out.println("TRANSFER SUCCESSFULL");

							break;
						case 3:
							System.out.println("******************************************************************");
							System.out.println("\t\t\t\tDEPOSIT");
							System.out.println("Please enter the amount you would like to deposit : ");
							double deposit = scan.nextDouble();
							scan.nextLine();
							System.out.println("Please enter the account Id of the account you would like to depposit the money into: ");
							int accountId = scan.nextInt();
							
							try {
								accountService.addMoney(deposit, accountId);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
					
						case 4:
							System.out.println("Thank you for using Our Banking App!! ");
							System.exit(0);
						}
						
						break;
					}

				
				// registering a new account/customer
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
