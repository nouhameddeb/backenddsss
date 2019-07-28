package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.MaintenanceCorrectiveNotFoundException;
import com.spark.gmao.model.entity.MaintenanceCorrective;
import com.spark.gmao.repository.MaintenanceCorrectiveRepository;
import com.spark.gmao.service.MaintenanceCorrectiveService;

@Service
public class MaintenanceCorrectiveServiceImpl implements MaintenanceCorrectiveService{
	
	@Autowired
	MaintenanceCorrectiveRepository maintenanceCorrectiveRepository;
	
	@Override
	public MaintenanceCorrective getMaintenanceCorrective(Long idCr) {
		MaintenanceCorrective maintenanceCorrective = maintenanceCorrectiveRepository.findOne(idCr);
		if(maintenanceCorrective == null) {
			throw new MaintenanceCorrectiveNotFoundException();
		}
		return maintenanceCorrective;
	}

	@Override
	public List<MaintenanceCorrective> getAllMaintenanceCorrective() {
		return (List<MaintenanceCorrective>) maintenanceCorrectiveRepository.findAll();
	}
	
	@Transactional
	@Override
	public MaintenanceCorrective saveMaintenanceCorrective(MaintenanceCorrective maintenanceCorrective) {
		return maintenanceCorrectiveRepository.save(maintenanceCorrective);
		
	}

	@Override
	public void deleteMaintenanceCorrective(Long idCr) {
		try {
			maintenanceCorrectiveRepository.delete(idCr);
		} catch (EmptyResultDataAccessException e) {
			throw new MaintenanceCorrectiveNotFoundException();
		}
		
	}


}
