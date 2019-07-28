package com.spark.gmao.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class DemandeInterventionDto {
	private Long idDemande;
	private Long emission;
	private Date dateDemande;
	private String demandeur;
	private Long tel;
	private Date datesouhaite;
	private String typePanne;
	private String causePanne;
	private String etatDemande;
	private String realisepar;
	private String localisationDemande;
	private String descDemande;
    private MachineDto machine;

}
