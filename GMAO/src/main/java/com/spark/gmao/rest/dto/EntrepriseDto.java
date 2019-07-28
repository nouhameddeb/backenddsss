package com.spark.gmao.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class EntrepriseDto {
	
	private long idEntrp;
	private String nomEntrp;
	private int telEntrp;
	private String adresseEntrp;

}
