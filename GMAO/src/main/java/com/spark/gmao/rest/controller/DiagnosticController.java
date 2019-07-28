package com.spark.gmao.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.gmao.model.entity.Diagnostic;
import com.spark.gmao.rest.dto.DiagnosticDto;
import com.spark.gmao.service.DiagnosticService;

@RestController
public class DiagnosticController {
	
    @Autowired
    private DiagnosticService diagnosticService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/diagnostics")
	public Object equipementsList() {
		List<Diagnostic> diagnostics = diagnosticService.getAllDiagnostic();
		Type listType = new TypeToken<List<DiagnosticDto>>(){}.getType();
		List<DiagnosticDto> diagnosticDto = modelMapper.map(diagnostics, listType);
		return ResponseEntity.status(HttpStatus.OK).body(diagnosticDto);
	}
	
	@GetMapping("/diagnostics/{idD}")
	public Object retrievediagnostic(@PathVariable Long idD) {
		Diagnostic diagnostic = diagnosticService.getDiagnostic(idD);
		DiagnosticDto diagnosticDto = modelMapper.map( diagnostic,  DiagnosticDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(diagnosticDto);
	}
	
	@PostMapping("/diagnostics")
	public Object saveDiagnostic(@Valid @RequestBody DiagnosticDto diagnosticDto) {
		Diagnostic diagnostic = modelMapper.map(diagnosticDto, Diagnostic.class);
		
		diagnostic = diagnosticService.saveDiagnostic(diagnostic);

		diagnosticDto = modelMapper.map(diagnostic, DiagnosticDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticDto);
	}
	
	@PutMapping("/diagnostics/{idD}")
	public Object updateDiagnostic(@Valid @RequestBody DiagnosticDto diagnosticDto, @PathVariable long idD) {
		Diagnostic diagnostic = modelMapper.map(diagnosticDto, Diagnostic.class);
		diagnostic.setIdDiagnostic(idD);
	diagnostic = diagnosticService.saveDiagnostic(diagnostic);
		
		diagnosticDto = modelMapper.map(diagnostic, DiagnosticDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(diagnostic);
	}
	
	@DeleteMapping("/diagnostics/{idD}")
	public Object Delete(@PathVariable("idD") long idD) {
		diagnosticService.deleteDiagnostic(idD);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
