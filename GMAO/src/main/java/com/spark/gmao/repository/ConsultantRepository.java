package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spark.gmao.model.entity.Consultant;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Long>{

}
