package Exceptions;

public class InsufficientFundsException extends Exception{

	@Override
	public String getMessage() {
		
		return "Account balance is insufficient to make transaction ";
	}
	
	

}
