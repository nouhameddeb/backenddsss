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

import com.spark.gmao.model.entity.MaintenancePreventive;
import com.spark.gmao.rest.dto.MaintenancePreventiveDto;
import com.spark.gmao.service.MaintenancePreventiveService;

@RestController
public class MaintenancePreventiveController {
	
	@Autowired
	private MaintenancePreventiveService maintenancePreventiveService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/preventives")
	public Object preventivesList() {
		List<MaintenancePreventive> maintenancePreventives = maintenancePreventiveService.getAllMaintenancePreventive();
		Type listType = new TypeToken<List<MaintenancePreventiveDto>>(){}.getType();
		List<MaintenancePreventiveDto> maintenancePreventiveDtos = modelMapper.map(maintenancePreventives, listType);
		return ResponseEntity.status(HttpStatus.OK).body(maintenancePreventiveDtos);
	}
	
	@GetMapping("/preventives/{idPr}")
	public Object retrieveMaintenancePreventive(@PathVariable Long idPr) {
		MaintenancePreventive maintenancePreventive = maintenancePreventiveService.getMaintenancePreventive(idPr);
		MaintenancePreventiveDto maintenancePreventiveDto = modelMapper.map( maintenancePreventive,  MaintenancePreventiveDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(maintenancePreventiveDto);
	}
	
	@PostMapping("/preventives")
	public Object saveMaintenancePreventive(@Valid @RequestBody MaintenancePreventiveDto maintenancePreventiveDto) {
		MaintenancePreventive maintenancePreventive = modelMapper.map(maintenancePreventiveDto, MaintenancePreventive.class);
		
		maintenancePreventive = maintenancePreventiveService.saveMaintenancePreventive(maintenancePreventive);

		maintenancePreventiveDto = modelMapper.map(maintenancePreventive, MaintenancePreventiveDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenancePreventive);
	}
	
	@PutMapping("/preventives/{idPr}")
	public Object updateMaintenancePreventive(@Valid @RequestBody MaintenancePreventiveDto maintenancePreventiveDto, @PathVariable long idM) {
		MaintenancePreventive maintenancePreventive = modelMapper.map(maintenancePreventiveDto, MaintenancePreventive.class);
		maintenancePreventive.setIdM(idM);
		maintenancePreventive = maintenancePreventiveService.saveMaintenancePreventive(maintenancePreventive);
		
	maintenancePreventiveDto = modelMapper.map(maintenancePreventive, MaintenancePreventiveDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(maintenancePreventive);
	}
	
	@DeleteMapping("/preventives/{idPr}")
	public Object Delete(@PathVariable("idPr") long idPr) {
		maintenancePreventiveService.deleteMaintenancePreventive(idPr);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
