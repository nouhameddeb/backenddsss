package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.OutillageNotFoundException;
import com.spark.gmao.model.entity.Outillage;
import com.spark.gmao.repository.OutillageRepository;
import com.spark.gmao.service.OutillageService;

@Service
public class OutillageServiceImpl implements OutillageService{
	
	@Autowired
	private OutillageRepository outillageRepository;
	
	@Override
	public Outillage getOutillage(Long idO) {
		Outillage outillage = outillageRepository.findOne(idO);
		if(outillage == null) {
			throw new OutillageNotFoundException();
		}
		return outillage;
	}

	@Override
	public List<Outillage> getAllOutillage() {
		return (List<Outillage>) outillageRepository.findAll();
	}
	
	@Transactional
	@Override
	public Outillage saveOutillage(Outillage outillage) {
		return outillageRepository.save(outillage);
	}

	@Override
	public void deleteOutillage(Long idO) {
		try {
			outillageRepository.delete(idO);
		} catch (EmptyResultDataAccessException e) {
			throw new OutillageNotFoundException();
		}
	}
}

