package Method;

public class AlphaBeta {
	public static String startsearch(Board[][] board, boolean white){
		//-----------------------------------------------------------
		//探索用のデータ構造を用意する。
		Board[][] probe = new[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				probe[i][j] = new Board(board[i][j].coordinate, 
				board[i][j].state, 
				board[i][j].whiteNextMove, 
				board[i][j].blackNextMove, 
				board[i][j].importance, 
				board[i][j].up[0], board[i][j].up[1], 
				board[i][j].up_left[0], board[i][j].up_left[1], 
				board[i][j].up_right[0], board[i][j].up_right[1], 
				board[i][j].left[0], board[i][j].left[1], 
				board[i][j].right[0], board[i][j].right[1], 
				board[i][j].down[0], board[i][j].down[1], 
				board[i][j].down_left[0], board[i][j].down_left[1], 
				board[i][j].down_right[0], board[i][j].down_right[1]);
			}
		}
		//-----------------------------------------------------------

		//-----------------------------------------------------------
		//

		//-----------------------------------------------------------
	}

	private static double alphabeta(Board[][] board, int level, double alpha, double beta,  boolean white){
	}
}
