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

import com.spark.gmao.model.entity.Outillage;
import com.spark.gmao.rest.dto.OutillageDto;
import com.spark.gmao.service.OutillageService;

@CrossOrigin("*")
@RestController
public class OutillageController {
	
	@Autowired
	private OutillageService outillageService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/outillages")
	public Object outillagesList() {
		List<Outillage> outillages = outillageService.getAllOutillage();
		Type listType = new TypeToken<List<OutillageDto>>(){}.getType();
		List<OutillageDto> outillageDtos = modelMapper.map(outillages, listType);
		return ResponseEntity.status(HttpStatus.OK).body(outillageDtos);
	}
	
	@GetMapping("/outillages/{idO}")
	public Object retrieveoutillage(@PathVariable Long idO) {
		Outillage outillage = outillageService.getOutillage(idO);
		OutillageDto outillageDto = modelMapper.map( outillage,  OutillageDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(outillageDto);
	}
	
	@PostMapping("/outillages")
	public Object saveOutillage(@Valid @RequestBody OutillageDto outillageDto) {
		Outillage outillage = modelMapper.map(outillageDto, Outillage.class);
		
		outillage = outillageService.saveOutillage(outillage);

		outillageDto = modelMapper.map(outillage, OutillageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(outillageDto);
	}
	
	@PutMapping("/outillages/{idO}")
	public Object updateOutillage(@Valid @RequestBody OutillageDto outillageDto, @PathVariable long idO) {
		Outillage outillage = modelMapper.map(outillageDto, Outillage.class);
		outillage.setIdOutillage(idO);
	outillage = outillageService.saveOutillage(outillage);
		
		outillageDto = modelMapper.map(outillage, OutillageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(outillage);
	}
	
	@DeleteMapping("/outillages/{idO}")
	public Object Delete(@PathVariable("idO") long idO) {
		outillageService.deleteOutillage(idO);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
