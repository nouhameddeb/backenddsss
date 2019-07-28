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

import com.spark.gmao.model.entity.Consultant;
import com.spark.gmao.rest.dto.ConsultantDto;
import com.spark.gmao.service.ConsultantService;

@RestController
public class ConsultantController {
	
	@Autowired
	private ConsultantService consultantService;

	@Autowired
	private ModelMapper modelMapper;
	
	//afficher tt les consultants
		@GetMapping("/consultants")
		public Object consultantsList() {
			List<Consultant> consultants = consultantService.getAllConsultant();
			Type listType = new TypeToken<List<ConsultantDto>>(){}.getType();
 		List<ConsultantDto> consultantDtos = modelMapper.map(consultants, listType);
			return ResponseEntity.status(HttpStatus.OK).body(consultantDtos);
		}
		
		//afficher par id
		@GetMapping("/consultants/{idConsultant}")
		public Object retrieveconsultant(@PathVariable Long idConsultant) {
			Consultant consultant = consultantService.getConsultant(idConsultant);
			ConsultantDto consultantDto = modelMapper.map( consultant,  ConsultantDto.class);
			return ResponseEntity.status(HttpStatus.OK).body(consultantDto);
		}
		
		
		//enregistrer consultants
		@PostMapping("/consultants")
		public Object saveConsultant(@Valid @RequestBody ConsultantDto consultantDto) {
			Consultant consultant = modelMapper.map(consultantDto, Consultant.class);
			
			consultant = consultantService.saveConsultant(consultant);

			consultantDto = modelMapper.map(consultant, ConsultantDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(consultantDto);
		}

		 //modifier consultant par id
		@PutMapping("/consultants/{idConsultant}")
		public Object updateConsultant(@Valid @RequestBody ConsultantDto consultantDto, @PathVariable long idConsultant) {
			Consultant consultant = modelMapper.map(consultantDto, Consultant.class);
			consultant.setIdConsultant(idConsultant);
		consultant = consultantService.saveConsultant(consultant);
			
			consultantDto = modelMapper.map(consultant, ConsultantDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(consultant);
		}
		
		//supprimer consultant par id
		@DeleteMapping("/consultants/{idConsultant}")
		public Object Delete(@PathVariable("idConsultant") long idConsultant) {
			consultantService.deleteConsultant(idConsultant);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}


}
