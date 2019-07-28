package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.MaintenanceCorrective;

public interface MaintenanceCorrectiveService {

	MaintenanceCorrective getMaintenanceCorrective(Long idCr);

	List<MaintenanceCorrective> getAllMaintenanceCorrective();

	MaintenanceCorrective saveMaintenanceCorrective(MaintenanceCorrective maintenanceCorrective);

	void deleteMaintenanceCorrective(Long idCr);

}
