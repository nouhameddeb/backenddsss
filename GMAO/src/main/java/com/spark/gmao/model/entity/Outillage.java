package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "OUTILLAGE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outillage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idO;
	
	@Column(name = "DESIGNATION", length = 50)
	private String designationO;
	
	@Column(name = "REFERENCE", length = 50)
	private String refO;
	
	@Column(name = "LIBELLE", length = 50)
	private String libelleO;
	
	@Column(name = "TYPE", length = 50)
	private String typeO;
	
	@Column(name = "QUANTITE", length = 50)
	private Integer quantiteO;
	
	@Column(name = "PRIX", length = 50)
	private Integer prixO;
	
	@Column(name = "DATE_ACHAT", length = 50)
	private Date dateO;
	
	@Column(name = "REMARQUE", length = 50)
	private String remarque;
	

	public void setIdOutillage(long idO) {
		// TODO Auto-generated method stub
		
	}

}
