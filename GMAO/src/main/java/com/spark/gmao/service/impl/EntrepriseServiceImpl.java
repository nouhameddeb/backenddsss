package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.EntrepriseNotFoundException;
import com.spark.gmao.model.entity.Entreprise;
import com.spark.gmao.repository.EntrepriseRepository;
import com.spark.gmao.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Override
	public Entreprise getEntreprise(Long idEntrp) {
		Entreprise entreprise = entrepriseRepository.findOne(idEntrp);
		if(entreprise == null) {
			throw new EntrepriseNotFoundException();
		}
		return entreprise;
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		return (List<Entreprise>) entrepriseRepository.findAll();
	}
	
	@Transactional
	@Override
	public Entreprise saveEntreprise(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
		
	}

	@Override
	public void deleteEntreprise(Long idEntrp) {
		try {
			entrepriseRepository.delete(idEntrp);
		} catch (EmptyResultDataAccessException e) {
			throw new EntrepriseNotFoundException();
		}
		
	}


}
