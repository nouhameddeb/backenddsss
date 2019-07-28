package com.spark.gmao.exception;

import com.spark.gmao.exception.DataNotFoundException;

public class OutillageNotFoundException extends DataNotFoundException{
	
private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Outillage not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public OutillageNotFoundException() {
		super(code, message);
	}
	

}
