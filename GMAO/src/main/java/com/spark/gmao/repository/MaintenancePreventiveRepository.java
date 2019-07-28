package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.MaintenancePreventive;

@Repository
public interface MaintenancePreventiveRepository extends CrudRepository<MaintenancePreventive, Long>{

}
