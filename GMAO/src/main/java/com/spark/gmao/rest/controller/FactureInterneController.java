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

import com.spark.gmao.model.entity.FactureInterne;
import com.spark.gmao.rest.dto.FactureInterneDto;
import com.spark.gmao.service.FactureInterneService;


@RestController
public class FactureInterneController {
	
	@Autowired
	private FactureInterneService factureInterneService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/factures")
	public Object facturesList() {
		List<FactureInterne> factures = factureInterneService.getAllFacture();
		Type listType = new TypeToken<List<FactureInterneDto>>(){}.getType();
		List<FactureInterneDto> factureDtos = modelMapper.map(factures, listType);
		return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
	}
	
	@GetMapping("/factures/{idF}")
	public Object retrievefacture(@PathVariable Long idF) {
		FactureInterne factureInterne = factureInterneService.getFacture(idF);
		FactureInterneDto factureInterneDto = modelMapper.map( factureInterne,  FactureInterneDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(factureInterneDto);
	}
	
	@PostMapping("/factures")
	public Object saveFacture(@Valid @RequestBody FactureInterneDto factureInterneDto) {
		FactureInterne factureInterne = modelMapper.map(factureInterneDto, FactureInterne.class);
		
		factureInterne = factureInterneService.saveFacture(factureInterne);

		factureInterneDto = modelMapper.map(factureInterne, FactureInterneDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(factureInterneDto);
	}
	
	@PutMapping("/factures/{idF}")
	public Object updateFacture(@Valid @RequestBody FactureInterneDto factureInterneDto, @PathVariable long idF) {
		FactureInterne factureInterne = modelMapper.map(factureInterneDto, FactureInterne.class);
		factureInterne.setIdF(idF);
	factureInterne = factureInterneService.saveFacture(factureInterne);
		
		factureInterneDto = modelMapper.map(factureInterne, FactureInterneDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(factureInterne);
	}
	
	@DeleteMapping("/factures/{idF}")
	public Object Delete(@PathVariable("idF") long idF) {
		factureInterneService.deleteFacture(idF);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}



}
