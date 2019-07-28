package com.spark.gmao.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spark.gmao.model.entity.DemandeIntervention;
import com.spark.gmao.rest.dto.DemandeInterventionDto;
import com.spark.gmao.service.DemandeInterventionService;

@CrossOrigin("*")
@RestController
public class DemandeInterventionController {
	
	@Autowired
	private DemandeInterventionService demandeInterventionService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/demandes")
	public Object demandesList() {
		List<DemandeIntervention> demandesIntervention = demandeInterventionService.getAllDemandeIntervention();
		Type listType = new TypeToken<List<DemandeInterventionDto>>(){}.getType();
		List<DemandeInterventionDto> demandeInterventionDtos = modelMapper.map(demandesIntervention, listType);
		return ResponseEntity.status(HttpStatus.OK).body(demandeInterventionDtos);
	}
	
	@GetMapping("/demandes/{idDemande}")
	public Object retrieveDemande_Intervention(@PathVariable Long idDemande) {
		DemandeIntervention demandeIntervention = demandeInterventionService.getDemandeIntervention(idDemande);
		DemandeInterventionDto demandeInterventionDto = modelMapper.map( demandeIntervention,  DemandeInterventionDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(demandeInterventionDto);
	}
	
	@PostMapping("/demandes")
	public Object saveDemande_Intervention(@Valid @RequestBody DemandeInterventionDto demandeInterventionDto) {
		DemandeIntervention demandeIntervention = modelMapper.map(demandeInterventionDto, DemandeIntervention.class);
		
		demandeIntervention = demandeInterventionService.saveDemandeIntervention(demandeIntervention);

		demandeInterventionDto = modelMapper.map(demandeIntervention, DemandeInterventionDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(demandeInterventionDto);
	}
	
	@PutMapping("/demandes/{idDemande}")
	public Object updateDemande_Intervention(@Valid @RequestBody DemandeInterventionDto demandeInterventionDto, @PathVariable long idDemande) {
		DemandeIntervention demandeIntervention = modelMapper.map(demandeInterventionDto, DemandeIntervention.class);
		demandeIntervention.setIdDemande(idDemande);
		demandeIntervention = demandeInterventionService.saveDemandeIntervention(demandeIntervention);
		
	demandeInterventionDto = modelMapper.map(demandeIntervention, DemandeInterventionDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(demandeIntervention);
	}
	
	@DeleteMapping("/demandes/{idDemande}")
	public Object Delete(@PathVariable("idDemande") long idDemande) {
		demandeInterventionService.deleteDemandeIntervention(idDemande);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	

}
