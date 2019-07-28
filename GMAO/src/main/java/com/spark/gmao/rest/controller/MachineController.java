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

import com.spark.gmao.model.entity.Machine;
import com.spark.gmao.rest.dto.MachineDto;
import com.spark.gmao.service.MachineService;

@CrossOrigin("*")
@RestController
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/machines")
	public Object machinesList() {
		List<Machine> machines = machineService.getAllMachine();
		Type listType = new TypeToken<List<MachineDto>>(){}.getType();
		List<MachineDto> machineDtos = modelMapper.map(machines, listType);
		return ResponseEntity.status(HttpStatus.OK).body(machineDtos);
	}
	
	@GetMapping("/machines/{idM}")
	public Object retrievemachine(@PathVariable Long idM) {
		Machine machine = machineService.getMachine(idM);
		MachineDto machineDto = modelMapper.map( machine,  MachineDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(machineDto);
	}
	
	@PostMapping("/machines")
	public Object saveMachine(@Valid @RequestBody MachineDto machineDto) {
		Machine machine = modelMapper.map(machineDto, Machine.class);
		
		machine = machineService.saveMachine(machine);

		machineDto = modelMapper.map(machine, MachineDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(machineDto);
	}
	
	@PutMapping("/machines/{idM}")
	public Object updateMachine(@Valid @RequestBody MachineDto machineDto, @PathVariable long idM) {
		Machine machine = modelMapper.map(machineDto, Machine.class);
		machine.setIdMachine(idM);
	machine = machineService.saveMachine(machine);
		
		machineDto = modelMapper.map(machine, MachineDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(machine);
	}
	
	@DeleteMapping("/machines/{idM}")
	public Object Delete(@PathVariable("idM") long idM) {
		machineService.deleteMachine(idM);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	

}
