package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.MaintenancePreventive;

public interface MaintenancePreventiveService {

	MaintenancePreventive getMaintenancePreventive(Long idPr);

	List<MaintenancePreventive> getAllMaintenancePreventive();

	MaintenancePreventive saveMaintenancePreventive(MaintenancePreventive maintenancePreventive);

	void deleteMaintenancePreventive(Long idPr);

}
