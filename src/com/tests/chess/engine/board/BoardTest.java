package com.tests.chess.engine.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Board.Builder;
import com.chess.engine.piece.Bishop;
import com.chess.engine.piece.Knight;
import com.chess.engine.piece.Pawn;
import com.chess.engine.piece.Queen;
import com.chess.engine.piece.Rook;

public class BoardTest {

	@Test
	public void initialBoard() {
		final Board board = Board.createStandardBoard();
		assertEquals(board.currentPlayer().getLegalMoves().size(), 20);
		assertEquals(board.currentPlayer().getOpponent().getLegalMoves().size(), 20);
		assertFalse(board.currentPlayer().isInCheck());
		assertFalse(board.currentPlayer().isInCheckMate());
		assertFalse(board.currentPlayer().isCastled());
		assertEquals(board.currentPlayer(), board.whitePlayer());
		assertEquals(board.currentPlayer().getOpponent(), board.blackPlayer());
		assertFalse(board.currentPlayer().getOpponent().isInCheck());
		assertFalse(board.currentPlayer().getOpponent().isInCheckMate());
		assertFalse(board.currentPlayer().getOpponent().isCastled());
	}
	
	@Test(expected=RuntimeException.class)
    public void testInvalidBoard() {

        final Builder builder = new Builder();
        // Black Layout
        builder.setPiece(new Rook(0, Alliance.BLACK));
        builder.setPiece(new Knight(1, Alliance.BLACK));
        builder.setPiece(new Bishop(2, Alliance.BLACK));
        builder.setPiece(new Queen(3, Alliance.BLACK));
        builder.setPiece(new Bishop(5, Alliance.BLACK));
        builder.setPiece(new Knight(6, Alliance.BLACK));
        builder.setPiece(new Rook(7, Alliance.BLACK));
        builder.setPiece(new Pawn(8, Alliance.BLACK));
        builder.setPiece(new Pawn(9, Alliance.BLACK));
        builder.setPiece(new Pawn(10, Alliance.BLACK));
        builder.setPiece(new Pawn(11, Alliance.BLACK));
        builder.setPiece(new Pawn(12, Alliance.BLACK));
        builder.setPiece(new Pawn(13, Alliance.BLACK));
        builder.setPiece(new Pawn(14, Alliance.BLACK));
        builder.setPiece(new Pawn(15, Alliance.BLACK));
        // White Layout
        builder.setPiece(new Pawn(48, Alliance.WHITE));
        builder.setPiece(new Pawn(49, Alliance.WHITE));
        builder.setPiece(new Pawn(50, Alliance.WHITE));
        builder.setPiece(new Pawn(51, Alliance.WHITE));
        builder.setPiece(new Pawn(52, Alliance.WHITE));
        builder.setPiece(new Pawn(53, Alliance.WHITE));
        builder.setPiece(new Pawn(54, Alliance.WHITE));
        builder.setPiece(new Pawn(55, Alliance.WHITE));
        builder.setPiece(new Rook(56, Alliance.WHITE));
        builder.setPiece(new Knight(57, Alliance.WHITE));
        builder.setPiece(new Bishop(58, Alliance.WHITE));
        builder.setPiece(new Queen(59, Alliance.WHITE));
        builder.setPiece(new Bishop(61, Alliance.WHITE));
        builder.setPiece(new Knight(62, Alliance.WHITE));
        builder.setPiece(new Rook(63, Alliance.WHITE));
        //white to move
        builder.setMoveMaker(Alliance.WHITE);
        //build the board
        builder.build();
    }
}