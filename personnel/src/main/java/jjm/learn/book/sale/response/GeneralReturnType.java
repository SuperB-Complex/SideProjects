package jjm.learn.book.sale.response;

public class GeneralReturnType {
	
	public static GeneralReturnType create(Object result) {
		return create(result, "success");
	}
	
	public static GeneralReturnType create(Object result, String status) {
		GeneralReturnType generalReturnType = new GeneralReturnType();
		generalReturnType.setStatus(status);
		generalReturnType.setData(result);
		return generalReturnType;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	// http code reflects return type-"success" "fail"
	private String status;
	
	// if status=success then return data
	// else return general error code
	private Object data;
	
}
