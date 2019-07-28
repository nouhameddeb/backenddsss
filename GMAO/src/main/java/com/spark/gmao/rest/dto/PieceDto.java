package com.spark.gmao.rest.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PieceDto {
	
	private long idPi;
	private String designationP;
	private String libelleP;
	private String refP;
	private Integer quantiteP;
	private Integer prixP;
	private Date dateP;

}
