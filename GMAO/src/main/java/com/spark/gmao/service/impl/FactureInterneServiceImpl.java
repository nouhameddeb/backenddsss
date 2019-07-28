package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.FactureInterneNotFoundException;
import com.spark.gmao.model.entity.FactureInterne;
import com.spark.gmao.repository.FactureInterneRepository;
import com.spark.gmao.service.FactureInterneService;

@Service
public class FactureInterneServiceImpl implements FactureInterneService{
	
	@Autowired
	private FactureInterneRepository factureInterneRepository;
	
	@Override
	public FactureInterne getFacture(Long idF) {
		FactureInterne factureInterne = factureInterneRepository.findOne(idF);
		if(factureInterne == null) {
			throw new FactureInterneNotFoundException();
		}
		return factureInterne;
	}

	@Override
	public List<FactureInterne> getAllFacture() {
		return (List<FactureInterne>) factureInterneRepository.findAll();
	}
	
	@Transactional
	@Override
	public FactureInterne saveFacture(FactureInterne factureInterne) {
		return factureInterneRepository.save(factureInterne);
		
	}

	@Override
	public void deleteFacture(Long idF) {
		try {
			factureInterneRepository.delete(idF);
		} catch (EmptyResultDataAccessException e) {
			throw new FactureInterneNotFoundException();
		}
		
	}


}
