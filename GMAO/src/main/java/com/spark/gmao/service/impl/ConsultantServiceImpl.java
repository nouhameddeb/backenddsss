package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.ConsultantNotFoundException;
import com.spark.gmao.model.entity.Consultant;
import com.spark.gmao.repository.ConsultantRepository;
import com.spark.gmao.service.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService{
	
	@Autowired
	private ConsultantRepository consultantRepository;

	@Override
	public Consultant getConsultant(Long idConsultant) {
		Consultant consultant = consultantRepository.findOne(idConsultant);
		if(consultant == null) {
			throw new ConsultantNotFoundException();
		}
		return consultant;
	}

	@Override
	public List<Consultant> getAllConsultant() {
		return (List<Consultant>) consultantRepository.findAll();
	}
	
	@Transactional
	@Override
	public Consultant saveConsultant(Consultant consultant) {
		return consultantRepository.save(consultant);
		
	}

	@Override
	public void deleteConsultant(Long idConsultant) {
		try {
			consultantRepository.delete(idConsultant);
		} catch (EmptyResultDataAccessException e) {
			throw new ConsultantNotFoundException();
		}
		
	}

}
