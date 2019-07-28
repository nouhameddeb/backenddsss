package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.RapportNotFoundException;
import com.spark.gmao.model.entity.Rapport;
import com.spark.gmao.repository.RapportRepository;
import com.spark.gmao.service.RapportService;

@Service
public class RapportServiceImpl implements RapportService{
	
	@Autowired
	private RapportRepository rapportRepository;
	
	@Override
	public Rapport getRapport(Long idR) {
		Rapport rapport = rapportRepository.findOne(idR);
		if(rapport == null) {
			throw new RapportNotFoundException();
		}
		return rapport;
	}

	@Override
	public List<Rapport> getAllRapport() {
		return (List<Rapport>) rapportRepository.findAll();
	}
	
	@Transactional
	@Override
	public Rapport saveRapport(Rapport rapport) {
		return rapportRepository.save(rapport);
		
	}

	@Override
	public void deleteRapport(Long idR) {
		try {
			rapportRepository.delete(idR);
		} catch (EmptyResultDataAccessException e) {
			throw new RapportNotFoundException();
		}
		
	}


}
