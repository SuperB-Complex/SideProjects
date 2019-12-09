package jjm.learn.book.sale.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jjm.learn.book.sale.error.BusinessException;
import jjm.learn.book.sale.error.EnumBusinessError;
import jjm.learn.book.sale.response.GeneralReturnType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public Object handleException(HttpServletRequest request, Exception exception) {
		
		BusinessException businessException = (BusinessException)exception;
		
		Map<String, Object> responseData = new HashMap<>();
		if (exception instanceof BusinessException) {

			responseData.put("errorCode", businessException.getErrorCode());
			responseData.put("errorMessage", businessException.getErrorMessage());
		} else {
			
			responseData.put("errorCode", EnumBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode());
			responseData.put("errorMessage", EnumBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMessage());
		}
		
		
		return GeneralReturnType.create(responseData, "fail");
//		GeneralReturnType generalReturnType = new GeneralReturnType();
//		generalReturnType.setStatus("fail");
//		generalReturnType.setData(responseData);
//		return generalReturnType;
	}
}
