package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Consultant;

public interface ConsultantService {

	Consultant getConsultant(Long idConsultant);

	List<Consultant> getAllConsultant();

	Consultant saveConsultant(Consultant consultant);

	void deleteConsultant(Long idConsultant);


}
