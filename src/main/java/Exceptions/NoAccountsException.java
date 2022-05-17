package Exceptions;

public class NoAccountsException extends Exception{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No accounts found";
	}

}
