package com.spark.gmao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.gmao.model.entity.Diagnostic;

@Repository
public interface DiagnosticRepository extends CrudRepository<Diagnostic, Long> {

}
