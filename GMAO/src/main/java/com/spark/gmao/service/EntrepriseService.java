package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Entreprise;

public interface EntrepriseService {

	Entreprise getEntreprise(Long idEntrp);

	List<Entreprise> getAllEntreprise();

	Entreprise saveEntreprise(Entreprise entreprise);

	void deleteEntreprise(Long idEntrp);

	

}
