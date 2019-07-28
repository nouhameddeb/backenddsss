package com.spark.gmao.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class FactureInterneDto {
	
	private Long idF;
	private Date dateF;
	private Integer montantF;
	private Integer valeur_MO;
	private Integer prixP;

}
