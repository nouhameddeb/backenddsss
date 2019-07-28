package com.spark.gmao.model.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "MAINTENANCE_PREVENTIVE")
@DiscriminatorValue("PREVENTIVE")
@AllArgsConstructor
@NoArgsConstructor
public class MaintenancePreventive extends Maintenance{
	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "DUREEP", length = 50)
	private Integer dureeP;
	
	@Column(name = "DESCRIPTIONP", length = 50)
	private String descriptionP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="DemandeIntervention")
	   private DemandeIntervention demandeIntervention;

	public MaintenancePreventive(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			Diagnostic diagnostic, FactureInterne factureInterne, Rapport rapport, Integer dureeP, String descriptionP,
			DemandeIntervention demandeIntervention) {
		super(idM, datedebut, datefin, consultant, pieces, diagnostic, factureInterne, rapport);
		this.dureeP = dureeP;
		this.descriptionP = descriptionP;
		this.demandeIntervention = demandeIntervention;
	}

	public MaintenancePreventive(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			Diagnostic diagnostic, FactureInterne factureInterne, Rapport rapport) {
		super(idM, datedebut, datefin, consultant, pieces, diagnostic, factureInterne, rapport);
	}
}
