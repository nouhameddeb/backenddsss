package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Diagnostic;

public interface DiagnosticService {

	Diagnostic getDiagnostic(Long idD);

	List<Diagnostic> getAllDiagnostic();

	Diagnostic saveDiagnostic(Diagnostic diagnostic);

	void deleteDiagnostic(Long idD);

}
