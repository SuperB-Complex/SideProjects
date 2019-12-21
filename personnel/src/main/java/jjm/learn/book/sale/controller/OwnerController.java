package jjm.learn.book.sale.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jjm.learn.book.sale.controller.VO.OwnerVO;
import jjm.learn.book.sale.error.BusinessException;
import jjm.learn.book.sale.error.EnumBusinessError;
import jjm.learn.book.sale.error.GeneralError;
import jjm.learn.book.sale.response.GeneralReturnType;
import jjm.learn.book.sale.service.OwnerService;
import jjm.learn.book.sale.service.model.OwnerModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
// name the controller
@Controller("owner")
// set url requesting path
@RequestMapping("/owner")
public class OwnerController extends BaseController {
	
	@Autowired
	private OwnerService ownerService;

	// http://localhost:8080/owner/get?id=1
	@RequestMapping("/get")
	@ResponseBody
	public GeneralReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
		// calling service to get information of a customer with id and return data to the front
		OwnerModel ownerModel = ownerService.getOwnerById(id);
		
		if (ownerModel == null) {
			throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
		}
		
		// {"status":"success","data":{"id":1,"name":"xxx","sex":"F","phonenumber":"123456789"}}
		return GeneralReturnType.create(convertFromModel(ownerModel));
	}
	
	public OwnerVO convertFromModel(OwnerModel ownerModel) {
		
		if (ownerModel == null) {
			return null;
		}
		
		OwnerVO ownerVO = new OwnerVO();
		BeanUtils.copyProperties(ownerModel, ownerVO);
		
		return ownerVO;
	}

}
