package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.DemandeIntervention;

public interface DemandeInterventionService {

	DemandeIntervention getDemandeIntervention(Long idDemande);

	List<DemandeIntervention> getAllDemande();

	DemandeIntervention saveDemandeIntervention(DemandeIntervention demandeIntervention);

	void deleteDemandeIntervention(Long idDemande);

	List<DemandeIntervention> getAllDemandeIntervention();

	

}
