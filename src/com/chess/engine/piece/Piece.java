package com.chess.engine.piece;

import java.util.Collection;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public abstract class Piece {

	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	protected final boolean isFirstMove;
	
	Piece(final int piecePosition, final Alliance pieceAlliance) {
		this.piecePosition = piecePosition;
		this.pieceAlliance = pieceAlliance;
		//TODO more works here!
		this.isFirstMove = false;
	}
	
	public int getPiecePosition() {
		return this.getPiecePosition();
	}

	public Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}
	
	public boolean isFirstMove() {
		return this.isFirstMove;
	}
	
	public abstract Collection<Move> calculateLegalMoves(final Board board);
}
