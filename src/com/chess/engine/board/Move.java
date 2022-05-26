package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.piece.Piece;

public abstract class Move {

	final Board board;
	final Piece movePiece;
	final int destinationCoordinate;
	
	public static final Move NULL_MOVE = new NullMove();
	
	private Move(final Board board, final Piece movePiece, final int destinationCoordinate) {
		this.board = board;
		this.movePiece = movePiece;
		this.destinationCoordinate = destinationCoordinate;
	}
	
	public int getCurrentCoordinate() {
		return this.getMovedPiece().getPiecePosition();
	}
	
	public int getDestinationCoordinate() {
		return this.destinationCoordinate;
	}
	
	public Piece getMovedPiece() {
		return movePiece;
	}
	
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

	public static final class MajorMove extends Move {
		
		public MajorMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	public static class AttackMove extends Move {
		
		final Piece attackedPiece;
		
		public AttackMove(final Board board, final Piece movePiece,
				final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movePiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}
	}	
	
	public static final class PawnMove extends Move {
		
		public PawnMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	public static class PawnAttackMove extends AttackMove {
		
		public PawnAttackMove(final Board board, final Piece movePiece, 
				final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movePiece, destinationCoordinate, attackedPiece);
		}
	}
	
	public static final class PawnEnPassantAttackMove extends PawnAttackMove {
		
		public PawnEnPassantAttackMove(final Board board, final Piece movePiece, 
				final int destinationCoordinate, final Piece attackedPiece) {
			super(board, movePiece, destinationCoordinate, attackedPiece);
		}
	}
	
	public static final class PawnJump extends Move {
		
		public PawnJump(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	static abstract class CastleMove extends Move {
		
		public CastleMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	public static final class KingSideCastleMove extends CastleMove {
		
		public KingSideCastleMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	public static final class QueenSideCastleMove extends CastleMove {
		
		public QueenSideCastleMove(final Board board, final Piece movePiece, final int destinationCoordinate) {
			super(board, movePiece, destinationCoordinate);
		}
	}
	
	public static final class NullMove extends Move {
		
		public NullMove() {
			super(null, null, -1);
		}
		
		@Override
		public Board execute() {
			throw new RuntimeException("Cannot execute the null move!");
		}
	}
	
	public static class MoveFactory {
		
		private MoveFactory() {
			throw new RuntimeException("Not instantiable!");
		}
		
		public static Move createMove(final Board board, final int currentCoordinate, final int destinationCoordinate) {
			for (final Move move : board.getAllLegalMoves()) {
				if (move.getCurrentCoordinate() == currentCoordinate &&
						move.getDestinationCoordinate() == destinationCoordinate) {
					return move;
				}
			}
			
			return NULL_MOVE;
		}
	}
}
