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

import com.spark.gmao.model.entity.MaintenanceCorrective;
import com.spark.gmao.rest.dto.MaintenanceCorrectiveDto;
import com.spark.gmao.service.MaintenanceCorrectiveService;

@RestController
public class MaintenanceCorrectiveController {
	
	@Autowired
	private MaintenanceCorrectiveService maintenanceCorrectiveService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/correctives")
	public Object correctivesList() {
		List<MaintenanceCorrective> maintenanceCorrectives = maintenanceCorrectiveService.getAllMaintenanceCorrective();
		Type listType = new TypeToken<List<MaintenanceCorrectiveDto>>(){}.getType();
		List<MaintenanceCorrectiveDto> maintenanceCorrectiveDtos = modelMapper.map(maintenanceCorrectives, listType);
		return ResponseEntity.status(HttpStatus.OK).body(maintenanceCorrectiveDtos);
	}
	
	@GetMapping("/correctives/{idCr}")
	public Object retrieveMaintenanceCorrective(@PathVariable Long idCr) {
		MaintenanceCorrective maintenanceCorrective = maintenanceCorrectiveService.getMaintenanceCorrective(idCr);
		MaintenanceCorrectiveDto maintenanceCorrectiveDto = modelMapper.map( maintenanceCorrective,  MaintenanceCorrectiveDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(maintenanceCorrectiveDto);
	}
	
	@PostMapping("/correctives")
	public Object saveMaintenanceCorrective(@Valid @RequestBody MaintenanceCorrectiveDto maintenanceCorrectiveDto) {
		MaintenanceCorrective maintenanceCorrective = modelMapper.map(maintenanceCorrectiveDto, MaintenanceCorrective.class);
		
		maintenanceCorrective = maintenanceCorrectiveService.saveMaintenanceCorrective(maintenanceCorrective);

		maintenanceCorrectiveDto = modelMapper.map(maintenanceCorrective, MaintenanceCorrectiveDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceCorrective);
	}
	
	@PutMapping("/correctives/{idCr}")
	public Object updateMaintenanceCorrective(@Valid @RequestBody MaintenanceCorrectiveDto maintenanceCorrectiveDto, @PathVariable long idM) {
		MaintenanceCorrective maintenanceCorrective = modelMapper.map(maintenanceCorrectiveDto, MaintenanceCorrective.class);
		maintenanceCorrective.setIdM(idM);
		maintenanceCorrective = maintenanceCorrectiveService.saveMaintenanceCorrective(maintenanceCorrective);
		
	maintenanceCorrectiveDto = modelMapper.map(maintenanceCorrective, MaintenanceCorrectiveDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceCorrective);
	}
	
	@DeleteMapping("/correctives/{idCr}")
	public Object Delete(@PathVariable("idCr") long idCr) {
		maintenanceCorrectiveService.deleteMaintenanceCorrective(idCr);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}



}
