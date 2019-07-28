package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Maintenance;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long>{

}
