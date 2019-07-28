package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.DiagnosticNotFoundException;
import com.spark.gmao.model.entity.Diagnostic;
import com.spark.gmao.repository.DiagnosticRepository;
import com.spark.gmao.service.DiagnosticService;

@Service
public class DiagnosticServiceImpl implements DiagnosticService{

	@Autowired
	private DiagnosticRepository diagnosticRepository;
	
	@Override
	public Diagnostic getDiagnostic(Long idD) {
		Diagnostic diagnostic = diagnosticRepository.findOne(idD);
		if(diagnostic == null) {
			throw new DiagnosticNotFoundException();
		}
		return diagnostic;
	}

	@Override
	public List<Diagnostic> getAllDiagnostic() {
		return (List<Diagnostic>) diagnosticRepository.findAll();
	}
	
	@Transactional
	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		return diagnosticRepository.save(diagnostic);
		
	}

	@Override
	public void deleteDiagnostic(Long idD) {
		try {
			diagnosticRepository.delete(idD);
		} catch (EmptyResultDataAccessException e) {
			throw new DiagnosticNotFoundException();
		}
		
	}

}
