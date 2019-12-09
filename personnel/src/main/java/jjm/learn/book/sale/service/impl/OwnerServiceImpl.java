package jjm.learn.book.sale.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jjm.learn.book.sale.POJO.OwnerInformationPOJO;
import jjm.learn.book.sale.POJO.OwnerPassWordPOJO;
import jjm.learn.book.sale.mapper.OwnerInformationPOJOMapper;
import jjm.learn.book.sale.mapper.OwnerPassWordPOJOMapper;
import jjm.learn.book.sale.service.OwnerService;
import jjm.learn.book.sale.service.model.OwnerModel;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerInformationPOJOMapper ownerInformationPOJOmapper;
	
	@Autowired
	private OwnerPassWordPOJOMapper ownerPassWordPOJOmapper;
	
	@Override
	public OwnerModel getOwnerById(Integer id) {
		// TODO Auto-generated method stub
		OwnerInformationPOJO ownerInformationPOJO = ownerInformationPOJOmapper.selectByPrimaryKey(id);
		
		if (ownerInformationPOJO == null) {
			return null;
		}
		
		OwnerPassWordPOJO ownerPassWordPOJO = ownerPassWordPOJOmapper.selectByOwnerId(ownerInformationPOJO.getId());
		
		return convertFromPOJO(ownerInformationPOJO, ownerPassWordPOJO);
	}
	
	private OwnerModel convertFromPOJO(OwnerInformationPOJO ownerInformationPOJO, OwnerPassWordPOJO ownerPassWordPOJO) {
		
		if (ownerInformationPOJO == null) {
			return null;
		}
		
		OwnerModel ownerModel = new OwnerModel();
		BeanUtils.copyProperties(ownerInformationPOJO, ownerModel);
		
		if (ownerPassWordPOJO != null) {
			ownerModel.setPassword(ownerPassWordPOJO.getPassword());
		}
		
		return ownerModel;
	}

}
