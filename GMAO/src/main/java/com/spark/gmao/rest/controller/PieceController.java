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

import com.spark.gmao.model.entity.Piece;
import com.spark.gmao.rest.dto.PieceDto;
import com.spark.gmao.service.PieceService;

@CrossOrigin("*")
@RestController
public class PieceController {
	
	@Autowired
	private PieceService pieceService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/pieces")
	public Object piecesList() {
		List<Piece> pieces = pieceService.getAllPiece();
		Type listType = new TypeToken<List<PieceDto>>(){}.getType();
		List<PieceDto> pieceDtos = modelMapper.map(pieces, listType);
		return ResponseEntity.status(HttpStatus.OK).body(pieceDtos);
	}
	
	//afficher par id
	@GetMapping("/pieces/{idPi}")
	public Object retrievepiece(@PathVariable Long idPi) {
		Piece piece = pieceService.getPiece(idPi);
		PieceDto pieceDto = modelMapper.map( piece,  PieceDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(pieceDto);
	}
	
	
	//enregistrer pieces
	@PostMapping("/pieces")
	public Object savePiece(@Valid @RequestBody PieceDto pieceDto) {
		Piece piece= modelMapper.map(pieceDto, Piece.class);
		
		piece = pieceService.savePiece(piece);

		pieceDto = modelMapper.map(piece, PieceDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(pieceDto);
	}

	 //modifier par id
	@PutMapping("/pieces/{idPi}")
	public Object updatePiece(@Valid @RequestBody PieceDto pieceDto, @PathVariable long idPi) {
		Piece piece = modelMapper.map(pieceDto, Piece.class);
		piece.setIdPi(idPi);
	piece = pieceService.savePiece(piece);
		
		pieceDto = modelMapper.map(piece, PieceDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(piece);
	}
	
	//supprimer par id
	@DeleteMapping("/pieces/{idPi}")
	public Object Delete(@PathVariable("idPi") long idPi) {
		pieceService.deletePiece(idPi);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
