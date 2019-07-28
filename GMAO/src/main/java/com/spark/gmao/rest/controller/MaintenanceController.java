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

import com.spark.gmao.model.entity.Maintenance;
import com.spark.gmao.rest.dto.MaintenanceDto;
import com.spark.gmao.service.MaintenanceService;

@RestController
public class MaintenanceController {
	
	@Autowired
	private MaintenanceService maintenanceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/maintenances")
	public Object maintenancesList() {
		List<Maintenance> maintenances = maintenanceService.getAllMaintenance();
		Type listType = new TypeToken<List<MaintenanceDto>>(){}.getType();
		List<MaintenanceDto> maintenanceDtos = modelMapper.map(maintenances, listType);
		return ResponseEntity.status(HttpStatus.OK).body(maintenanceDtos);
	}
	
	@GetMapping("/maintenances/{idM}")
	public Object retrievemaintenance(@PathVariable Long idM) {
		Maintenance maintenance = maintenanceService.getMaintenance(idM);
		MaintenanceDto maintenanceDto = modelMapper.map( maintenance,  MaintenanceDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(maintenanceDto);
	}
	
	@PostMapping("/maintenances")
	public Object saveMaintenance(@Valid @RequestBody MaintenanceDto maintenanceDto) {
		Maintenance maintenance = modelMapper.map(maintenanceDto, Maintenance.class);
		
		maintenance = maintenanceService.saveMaintenance(maintenance);

		maintenanceDto = modelMapper.map(maintenance, MaintenanceDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceDto);
	}

	 //modifier consultant par id
	@PutMapping("/maintenances/{idM}")
	public Object updateMaintenance(@Valid @RequestBody MaintenanceDto maintenanceDto, @PathVariable long idM) {
		Maintenance maintenance = modelMapper.map(maintenanceDto, Maintenance.class);
		maintenance.setIdM(idM);
	maintenance = maintenanceService.saveMaintenance(maintenance);
		
		maintenanceDto = modelMapper.map(maintenance, MaintenanceDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenance);
	}
	
	//supprimer consultant par id
	@DeleteMapping("/maintenances/{idM}")
	public Object Delete(@PathVariable("idM") long idM) {
		maintenanceService.deleteMaintenance(idM);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
