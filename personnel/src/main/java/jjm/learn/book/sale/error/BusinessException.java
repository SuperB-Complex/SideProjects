package jjm.learn.book.sale.error;

public class BusinessException extends Exception implements GeneralError {
	
	private GeneralError generalError;
	
	public BusinessException(GeneralError generalError) {
		super();
		this.generalError = generalError;
	}
	
	public BusinessException(GeneralError generalError, String customerizedErrorMessage) {
		super();
		this.generalError = generalError;
		generalError.setErrorMessage(customerizedErrorMessage);
	}

	@Override
	public int getErrorCode() {
		// TODO Auto-generated method stub
		return this.generalError.getErrorCode();
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return this.generalError.getErrorMessage();
	}

	@Override
	public GeneralError setErrorMessage(String errorMessage) {
		// TODO Auto-generated method stub
		this.generalError.setErrorMessage(errorMessage);
		return this;
	}

}
