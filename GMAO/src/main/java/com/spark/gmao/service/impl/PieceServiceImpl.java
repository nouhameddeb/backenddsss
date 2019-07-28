package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.PieceNotFoundException;
import com.spark.gmao.model.entity.Piece;
import com.spark.gmao.repository.PieceRepository;
import com.spark.gmao.service.PieceService;

@Service
public class PieceServiceImpl implements PieceService{
	
	@Autowired
	private PieceRepository pieceRepository;
	
	@Override
	public Piece getPiece(Long idPi) {
		Piece piece = pieceRepository.findOne(idPi);
		if(piece == null) {
			throw new PieceNotFoundException();
		}
		return piece;
	}

	@Override
	public List<Piece> getAllPiece() {
		return (List<Piece>) pieceRepository.findAll();
	}
	
	@Transactional
	@Override
	public Piece savePiece(Piece piece) {
		return pieceRepository.save(piece);
		
	}

	@Override
	public void deletePiece(Long idPi) {
		try {
			pieceRepository.delete(idPi);
		} catch (EmptyResultDataAccessException e) {
			throw new PieceNotFoundException();
		}
		
	}


}
