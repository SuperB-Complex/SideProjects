personnel
	src
		main
			java
				jjm
					learn
						book
							sale
								App.java -- entry file
								controller
									BaseController.java -- define the exception handler
									OwnerController.java -- get user by condition
										VO
											OwnerVO.java -- the view that will be presented at front
								response
									GeneralReturnType.java -- define a general return structure
								service
									OwnerService.java -- interface contain contracts requiring by the users or the fron end
									impl
										OwnerServiceImpl.java -- implement contracts
									model
										OwnerModel.java -- model special for service needs
								error
									GeneralError.java -- interface contains certain contract
									BusinessException.java -- implement interface GeneralError
									EnumBusinessError.java -- define constants implement interface GeneralError
								POJO
									OwnerInformationPOJO.java -- corresponding to the actual table in database 
									OwnerPassWordPOJO.java -- corresponding to the actual table in database
								mapper
									OwnerInformationPOJOMapper.java -- CRUD
									OwnerPassWordPOJOMapper.java -- CRUD
			resource
				mapping -- auto-generate
					OwnerInformationPOJOMapper.xml
					OwnerPassWordPOJOMapper.xml
				application.properties
				mybatis-generator.out.xml
				mybatis-generator.xml
	pom.xml			