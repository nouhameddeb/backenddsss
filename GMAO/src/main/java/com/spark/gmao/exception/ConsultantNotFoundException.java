package com.spark.gmao.exception;

import com.spark.gmao.exception.DataNotFoundException;

public class ConsultantNotFoundException extends DataNotFoundException{
	

private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Consultant not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public ConsultantNotFoundException() {
		super(code, message);
	}
	

}
