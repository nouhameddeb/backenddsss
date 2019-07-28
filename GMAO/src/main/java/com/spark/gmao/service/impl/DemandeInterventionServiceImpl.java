package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.DemandeInterventionNotFoundException;
import com.spark.gmao.model.entity.DemandeIntervention;
import com.spark.gmao.repository.DemandeInterventionRepository;
import com.spark.gmao.service.DemandeInterventionService;

@Service
public class DemandeInterventionServiceImpl implements DemandeInterventionService{
	
	@Autowired
	private DemandeInterventionRepository demandeInterventionRepository;
	
	@Override
	public DemandeIntervention getDemandeIntervention(Long idDemande) {
		DemandeIntervention demandeIntervention = demandeInterventionRepository.findOne(idDemande);
		if(demandeIntervention == null) {
			throw new DemandeInterventionNotFoundException();
		}
		return demandeIntervention;
	}

	@Override
	public List<DemandeIntervention> getAllDemande() {
		return (List<DemandeIntervention>) demandeInterventionRepository.findAll();
	}
	
	@Transactional
	@Override
	public DemandeIntervention saveDemandeIntervention(DemandeIntervention demandeIntervention) {
		return demandeInterventionRepository.save(demandeIntervention);
		
	}

	@Override
	public void deleteDemandeIntervention(Long idDemande) {
		try {
			demandeInterventionRepository.delete(idDemande);
		} catch (EmptyResultDataAccessException e) {
			throw new DemandeInterventionNotFoundException();
		}
		
	}

	@Override
	public List<DemandeIntervention> getAllDemandeIntervention() {
		return (List<DemandeIntervention>) demandeInterventionRepository.findAll();
	}


}
