package com.spark.gmao.rest.dto;

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
public class ConsultantDto {
	
	private Long idConsultant;
	private String cin;
	private String nom;
	private String prenom;
	private String telephone;
	private String adresse;
	private String email;

}
