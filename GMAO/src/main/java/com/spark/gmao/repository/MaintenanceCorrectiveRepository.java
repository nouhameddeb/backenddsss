package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.MaintenanceCorrective;

@Repository
public interface MaintenanceCorrectiveRepository extends CrudRepository<MaintenanceCorrective, Long>{

}
