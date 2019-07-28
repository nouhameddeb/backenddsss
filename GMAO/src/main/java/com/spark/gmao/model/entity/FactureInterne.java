package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FACTURE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureInterne implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idF;
	
	@Column(name = "DATE_FACTURE", length = 50)
	 private Date dateF;
	
	@Column(name = "MONTANT_FACTURE", length = 50)
	 private Integer montantF;
	
	@Column(name = "VALEUR_MO", length = 50)
	 private Integer valeur_MO; //main d'oeuvre
	
	@Column(name = "PRIX_PIECES", length = 50)
	 private Integer prixP;
	
	@OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name ="idM")
	  private Maintenance maintenance;

}
