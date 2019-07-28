package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Piece;

public interface PieceService {

	Piece getPiece(Long idPi);

	List<Piece> getAllPiece();

	Piece savePiece(Piece piece);

	void deletePiece(Long idPi);

}
