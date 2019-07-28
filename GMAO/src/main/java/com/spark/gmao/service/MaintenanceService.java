package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Maintenance;

public interface MaintenanceService {

	Maintenance getMaintenance(Long idM);

	List<Maintenance> getAllMaintenance();

	Maintenance saveMaintenance(Maintenance maintenance);

	void deleteMaintenance(Long idM);

	Maintenance updateMaintenance(long idM);

}
