package com.spark.gmao.exception;

public class DemandeInterventionNotFoundException extends DataNotFoundException{
	
private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Demande d'intervention not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public DemandeInterventionNotFoundException() {
	
		super(code, message);
	}

}
