package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.piece.Piece;

public abstract class Move {

	final Board board;
	final Piece movePiece;
	final int destinationCoordinate;
	
	private Move(final Board board, final Piece movePiece, final int destinationCoordinate) {
		this.board = board;
		this.movePiece = movePiece;
		this.destinationCoordinate = destinationCoordinate;
	}
	
	public int getDestinationCoordinate() {
		return this.destinationCoordinate;
	}
	
	public Piece getMovePiece() {
		return movePiece;
	}
	
	public abstract Board execute();
	
	public static final class MajorMove extends Move {
		
		public MajorMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}

		@Override
		public Board execute() {
			final Builder builder = new Builder();
			
			// TODO implement equals method for pieces.
			for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
				if (!this.movePiece.equals(piece)) {
					builder.setPiece(piece);
				}
			}
			
			for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePieces()) {
				builder.setPiece(piece);
			}
			builder.setPiece(this.movePiece.movePiece(this));
			builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
			
			return builder.build();
		}
	}
	
	public static final class AttackMove extends Move {
		
		final Piece attackedPiece;
		
		public AttackMove(final Board board, final Piece movePiece,
				final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movePiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}

		@Override
		public Board execute() {
			// TODO Auto-generated method stub
			return null;
		}
	}	
}
