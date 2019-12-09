package jjm.learn.book.sale.error;

public interface GeneralError {
	int getErrorCode();
	String getErrorMessage();
	GeneralError setErrorMessage(String errorMessage);
}
