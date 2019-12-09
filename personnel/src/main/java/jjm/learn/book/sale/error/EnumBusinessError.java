package jjm.learn.book.sale.error;

public enum EnumBusinessError implements GeneralError {
	PARAMETER_VALIDATION_ERROR(20001, "parameter not valid"),
	
	USER_NOT_EXIST(10001, "Owner not existed");

	private EnumBusinessError(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	private int errorCode;
	private String errorMessage;

	@Override
	public int getErrorCode() {
		// TODO Auto-generated method stub
		return this.errorCode;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}

	@Override
	public GeneralError setErrorMessage(String errorMessage) {
		// TODO Auto-generated method stub
		this.errorMessage = errorMessage;
		return this;
	}
	
}
