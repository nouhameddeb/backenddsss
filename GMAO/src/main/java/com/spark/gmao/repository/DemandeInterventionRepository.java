package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.DemandeIntervention;

@Repository
public interface DemandeInterventionRepository extends CrudRepository<DemandeIntervention, Long>{

}
