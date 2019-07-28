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

import com.spark.gmao.model.entity.Rapport;
import com.spark.gmao.rest.dto.RapportDto;
import com.spark.gmao.service.RapportService;


@RestController
public class RapportController {
	
	@Autowired
	private RapportService rapportService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/rapports")
	public Object rapportsList() {
		List<Rapport> rapports = rapportService.getAllRapport();
		Type listType = new TypeToken<List<RapportDto>>(){}.getType();
		List<RapportDto> rapportDtos = modelMapper.map(rapports, listType);
		return ResponseEntity.status(HttpStatus.OK).body(rapportDtos);
	}
	
	//afficher par id
		@GetMapping("/rapports/{idR}")
		public Object retrieverapport(@PathVariable Long idR) {
			Rapport rapport = rapportService.getRapport(idR);
			RapportDto rapportDto = modelMapper.map( rapport,  RapportDto.class);
			return ResponseEntity.status(HttpStatus.OK).body(rapportDto);
		}
		
		
		//enregistrer pieces
		@PostMapping("/rapports")
		public Object saveRapport(@Valid @RequestBody RapportDto rapportDto) {
			Rapport rapport= modelMapper.map(rapportDto, Rapport.class);
			
			rapport = rapportService.saveRapport(rapport);

			rapportDto = modelMapper.map(rapport, RapportDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(rapportDto);
		}

		 //modifier par id
		@PutMapping("/rapports/{idR}")
		public Object updateRapport(@Valid @RequestBody RapportDto rapportDto, @PathVariable long idR) {
			Rapport rapport = modelMapper.map(rapportDto, Rapport.class);
			rapport.setIdR(idR);
		rapport = rapportService.saveRapport(rapport);
			
			rapportDto = modelMapper.map(rapport, RapportDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(rapport);
		}
		
		//supprimer par id
		@DeleteMapping("/rapports/{idR}")
		public Object Delete(@PathVariable("idR") long idR) {
			rapportService.deleteRapport(idR);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}



}
