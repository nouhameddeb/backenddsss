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
@Table(name = "DIAGNOSTIC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostic implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idD;
	
	@Column(name = "TYPE", length = 50, nullable = false)
	 private String type; //par telephone ou sur place
	
	@Column(name = "DateDebut", length = 50, nullable = false)
	 private Date dateDebut;
	
	@Column(name = "DateFin", length = 50, nullable = false)
	 private Date dateFin;
	
	@Column(name = "DESCRIPTION", length = 50, nullable = false)
	private String description;
	
	 @OneToMany(mappedBy = "diagnostic", fetch = FetchType.LAZY)
	   private Set<Maintenance> maintenances;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idDemande")
	   private DemandeIntervention demandeIntervention;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idConsultant")
	   private Consultant consultant;

	public void setIdDiagnostic(long idD) {
		// TODO Auto-generated method stub
		
	}

}
