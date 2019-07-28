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
public class OutillageDto {
	
	private Long idO;
	private String designationO;

	private String refO;
	private String libelleO;
	private Date dateO;
	private String typeO;
	private Integer quantiteO;
	private Integer prixO;
	private String remarque;

}
