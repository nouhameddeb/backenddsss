package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "DEMANDEINTERVENTION")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DemandeIntervention implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDemande;
	
	@Column(name = "N°EMISSION", length = 50, nullable = false)
	 private Long emission;
	
	 
	 @Column(name = "DATE_DEMANDE", length = 50, nullable = false)
	 private Date dateDemande;
	 
	 @Column(name = "DEMANDEUR", length = 50, nullable = false)
	 private String demandeur;
	 
	 @Column(name = "TELEPHONE", length = 50, nullable = false)
	 private Long tel;
	 	 
	 @Column(name = "DATE_SOUHAITE", length = 50, nullable = false)
	 private Date datesouhaite;
	 
	 @Column(name = "TYPE_PANNE", length = 50, nullable = false)
	 private String typePanne;
	 
	 @Column(name = "CAUSE_PANNE", length = 50, nullable = false)
	 private String causePanne;
	 
	 @Column(name = "ETAT_DEMANDE", length = 50, nullable = false)
	 private String etatDemande;
	 
	 
	 @Column(name = "REALISE_PAR", length = 50, nullable = false)
	 private String realisepar;
	 
	 @Column(name = "LOCALISATION", length = 50, nullable = false)
	 private String localisationDemande;
	 
	 @Column(name = "DESCRIPTION", length = 50, nullable = false)
	 private String descDemande;
	 
	 @OneToMany(mappedBy = "demandeIntervention", fetch = FetchType.LAZY)
	   private Set<Diagnostic> diagnostics;
	 
	 @OneToMany(mappedBy = "demandeIntervention", fetch = FetchType.LAZY)
	   private Set<MaintenancePreventive> maintenancePreventives;
 
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="machine")
	   private Machine machine;
	
}
