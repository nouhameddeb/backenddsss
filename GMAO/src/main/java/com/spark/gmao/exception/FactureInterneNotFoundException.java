package com.spark.gmao.exception;

public class FactureInterneNotFoundException extends DataNotFoundException{
	
   private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Facture not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public FactureInterneNotFoundException() {
		super(code, message);
	}


}
