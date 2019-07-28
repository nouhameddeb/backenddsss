package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long>{

}
