package com.zc.leh;

public class CustomException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5575855558721538730L;
	
	private String exceptionMsg;
	public CustomException (String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return exceptionMsg;
	}
	
}
