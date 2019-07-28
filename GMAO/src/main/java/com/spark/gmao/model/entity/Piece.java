package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PIECE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piece implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPi;
	
	@Column(name = "LIBELLE", length = 50, nullable = false)
	private String libelleP;
	
	@Column(name = "DESIGNATION", length = 50, nullable = false)
	private String designationP;
	
	@Column(name = "REFERENCE", length = 50, nullable = false)
	private String refP;
	
	@Column(name = "QUANTITE", length = 50, nullable = false)
	private Integer quantiteP;
	
	@Column(name = "PRIX", length = 50, nullable = false)
	private Integer prixP;
	
	@Column(name = "DATE_ACHAT", length = 50, nullable = false)
	private Date dateP;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idM")
	   private Maintenance maintenance;

}

