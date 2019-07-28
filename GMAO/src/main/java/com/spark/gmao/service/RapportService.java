package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Rapport;

public interface RapportService {

	Rapport getRapport(Long idR);

	List<Rapport> getAllRapport();

	Rapport saveRapport(Rapport rapport);

	void deleteRapport(Long idR);

}
