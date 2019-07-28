package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.MaintenanceNotFoundException;
import com.spark.gmao.model.entity.Maintenance;
import com.spark.gmao.repository.MaintenanceRepository;
import com.spark.gmao.service.MaintenanceService;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{
	
	@Autowired
	private MaintenanceRepository maintenanceRepository;
	
	@Override
	public Maintenance getMaintenance(Long idM) {
		Maintenance maintenance = maintenanceRepository.findOne(idM);
		if(maintenance == null) {
			throw new MaintenanceNotFoundException();
		}
		return maintenance;
	}

	@Override
	public List<Maintenance> getAllMaintenance() {
		return (List<Maintenance>) maintenanceRepository.findAll();
	}
	
	@Transactional
	@Override
	public Maintenance saveMaintenance(Maintenance maintenance) {
		return maintenanceRepository.save(maintenance);
		
	}
	
	@Override
	@Transactional
	public Maintenance updateMaintenance(long idM) {
		Maintenance maintenance = getMaintenance(idM);
		//maintenance.setIdM(maintenance);
		return saveMaintenance(maintenance);
	}

	@Override
	public void deleteMaintenance(Long idM) {
		try {
			maintenanceRepository.delete(idM);
		} catch (EmptyResultDataAccessException e) {
			throw new MaintenanceNotFoundException();
		}
		
	}


}
