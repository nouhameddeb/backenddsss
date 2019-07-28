package com.spark.gmao.exception;

public class MachineNotFoundException extends DataNotFoundException{
	
private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Machine not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public MachineNotFoundException() {
		super(code, message);
	}


}
