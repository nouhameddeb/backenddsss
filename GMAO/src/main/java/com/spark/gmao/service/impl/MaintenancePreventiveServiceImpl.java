package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.MaintenancePreventiveNotFoundException;
import com.spark.gmao.model.entity.MaintenancePreventive;
import com.spark.gmao.repository.MaintenancePreventiveRepository;
import com.spark.gmao.service.MaintenancePreventiveService;

@Service
public class MaintenancePreventiveServiceImpl implements MaintenancePreventiveService{
	
	@Autowired
	MaintenancePreventiveRepository maintenancePreventiveRepository;
	
	@Override
	public MaintenancePreventive getMaintenancePreventive(Long idPr) {
		MaintenancePreventive maintenancePreventive = maintenancePreventiveRepository.findOne(idPr);
		if(maintenancePreventive == null) {
			throw new MaintenancePreventiveNotFoundException();
		}
		return maintenancePreventive;
	}

	@Override
	public List<MaintenancePreventive> getAllMaintenancePreventive() {
		return (List<MaintenancePreventive>) maintenancePreventiveRepository.findAll();
	}
	
	@Transactional
	@Override
	public MaintenancePreventive saveMaintenancePreventive(MaintenancePreventive maintenancePreventive) {
		return maintenancePreventiveRepository.save(maintenancePreventive);
		
	}

	@Override
	public void deleteMaintenancePreventive(Long idPr) {
		try {
			maintenancePreventiveRepository.delete(idPr);
		} catch (EmptyResultDataAccessException e) {
			throw new MaintenancePreventiveNotFoundException();
		}
		
	}


}
