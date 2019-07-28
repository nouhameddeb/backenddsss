package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Outillage;

public interface OutillageService {

	Outillage getOutillage(Long idO);


	Outillage saveOutillage(Outillage outillage);

	void deleteOutillage(Long idO);


	List<Outillage> getAllOutillage();

}
