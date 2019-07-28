package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Outillage;

@Repository
public interface OutillageRepository extends CrudRepository<Outillage, Long>{

}
