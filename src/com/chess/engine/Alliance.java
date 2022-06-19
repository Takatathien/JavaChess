package com.chess.engine;

import com.chess.engine.board.BoardUtils;
import com.chess.engine.player.BlackPlayer;
import com.chess.engine.player.Player;
import com.chess.engine.player.WhitePlayer;

public enum Alliance {

	WHITE {
		@Override
		public int getDirection() {
			return UP_DIRECTION;
		}
		
		@Override
		public int getOppositeDirection() {
			return DOWN_DIRECTION;
		}

		@Override
		public boolean isWhite() {
			return true;
		}

		@Override
		public boolean isBlack() {
			return false;
		}


		@Override
		public boolean isPawnPromotionSquare(int position) {
			return BoardUtils.EIGHTH_RANK[position];
		}
		
		@Override
		public Player choosePlayer(final WhitePlayer whitePlayer, 
				                   final BlackPlayer blackPlayer) {
			return whitePlayer;
		}
		
		@Override
		public String toString() {
			return "White";
		}
	}, 
	BLACK {
		@Override
		public int getDirection() {
			return DOWN_DIRECTION;
		}
		
		@Override
		public int getOppositeDirection() {
			return UP_DIRECTION;
		}

		@Override
		public boolean isWhite() {
			return false;
		}

		@Override
		public boolean isBlack() {
			return true;
		}
		

		@Override
		public boolean isPawnPromotionSquare(int position) {
			return BoardUtils.FIRST_RANK[position];
		}

		@Override
		public Player choosePlayer(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer) {
			return blackPlayer;
		}
	};
	
	private static final int UP_DIRECTION = -1;
	private static final int DOWN_DIRECTION = 1;
	
	public abstract int getDirection();
	public abstract int getOppositeDirection();
	public abstract boolean isWhite();
	public abstract boolean isBlack();
	public abstract boolean isPawnPromotionSquare(int position);
	public abstract Player choosePlayer(WhitePlayer whitePlayer, BlackPlayer blackPlayer);

}
