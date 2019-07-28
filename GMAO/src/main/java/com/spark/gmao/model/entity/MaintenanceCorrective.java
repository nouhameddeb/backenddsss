package com.spark.gmao.model.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MAINTENANCE_CORRECTIVE")
@DiscriminatorValue("Corrective")
public class MaintenanceCorrective extends Maintenance{
	
	private static final long serialVersionUID = 1L;


	@Column(name = "DUREE", length = 50)
	private Integer duree;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	public MaintenanceCorrective(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			Diagnostic diagnostic, FactureInterne factureInterne, Rapport rapport, Integer duree, String description) {
		super(idM, datedebut, datefin, consultant, pieces, diagnostic, factureInterne, rapport);
		this.duree = duree;
		this.description = description;
	}

	public MaintenanceCorrective(Long idM, Date datedebut, Date datefin, Consultant consultant, Set<Piece> pieces,
			Diagnostic diagnostic, FactureInterne factureInterne, Rapport rapport) {
		super(idM, datedebut, datefin, consultant, pieces, diagnostic, factureInterne, rapport);
	}
	
}
