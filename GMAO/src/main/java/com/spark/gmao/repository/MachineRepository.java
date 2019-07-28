package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Machine;

@Repository
public interface MachineRepository extends CrudRepository<Machine, Long> {

}
