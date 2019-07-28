package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.FactureInterne;

public interface FactureInterneService {


	List<FactureInterne> getAllFacture();

	FactureInterne saveFacture(FactureInterne factureInterne);

	void deleteFacture(Long idF);

	FactureInterne getFacture(Long idF);

}
