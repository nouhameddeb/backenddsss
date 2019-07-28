package com.spark.gmao.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MachineDto {
	
	private Long idM;
	private String designation;
	private String code;
	private String libelle;
	private String reference;
	private String type;
	private String modele;
	private String marque;
	private String fournisseur;
	private String fabricant;
	private Date dateAcquisition;
	private Date finGarantie;
	private String criticite;
	private String etat;

}
