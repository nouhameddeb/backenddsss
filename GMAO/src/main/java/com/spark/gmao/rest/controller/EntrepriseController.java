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

import com.spark.gmao.model.entity.Entreprise;
import com.spark.gmao.rest.dto.EntrepriseDto;
import com.spark.gmao.service.EntrepriseService;

@RestController
public class EntrepriseController {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/entreprises")
	public Object entreprisesList() {
		List<Entreprise> entreprises = entrepriseService.getAllEntreprise();
		Type listType = new TypeToken<List<EntrepriseDto>>(){}.getType();
		List<EntrepriseDto> entrepriseDtos = modelMapper.map(entreprises, listType);
		return ResponseEntity.status(HttpStatus.OK).body(entrepriseDtos);
	}
	
	@GetMapping("/entreprises/{idEntrp}")
	public Object retrieveentreprise(@PathVariable Long idEntrp) {
		Entreprise entreprise = entrepriseService.getEntreprise(idEntrp);
		EntrepriseDto entrepriseDto = modelMapper.map( entreprise,  EntrepriseDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(entrepriseDto);
	}
	
	@PostMapping("/entreprises")
	public Object saveEntreprise(@Valid @RequestBody EntrepriseDto entrepriseDto) {
		Entreprise entreprise = modelMapper.map(entrepriseDto, Entreprise.class);
		
		entreprise = entrepriseService.saveEntreprise(entreprise);

		entrepriseDto = modelMapper.map(entreprise, EntrepriseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entrepriseDto);
	}
	
	@PutMapping("/entreprises/{idEntrp}")
	public Object updateConsultant(@Valid @RequestBody EntrepriseDto entrepriseDto, @PathVariable long idEntrp) {
		Entreprise entreprise = modelMapper.map(entrepriseDto, Entreprise.class);
		entreprise.setIdEntrp(idEntrp);
	entreprise = entrepriseService.saveEntreprise(entreprise);
		
		entrepriseDto = modelMapper.map(entreprise, EntrepriseDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(entreprise);
	}
	
	@DeleteMapping("/entreprises/{idEntrp}")
	public Object Delete(@PathVariable("idEntrp") long idEntrp) {
		entrepriseService.deleteEntreprise(idEntrp);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}



}
