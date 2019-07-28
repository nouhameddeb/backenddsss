package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.FactureInterne;

@Repository
public interface FactureInterneRepository extends CrudRepository<FactureInterne, Long>{

}
