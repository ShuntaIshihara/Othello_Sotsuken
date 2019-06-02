package Method;

public class AlphaBeta {
	public static String startsearch(Board[][] board, boolean white){
		//-----------------------------------------------------------
		//探索用のデータ構造を用意する。
		Board[][] probe = new Board[8][8];
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
		//alphabetaメソッドを呼び出す。
		double k = alphabeta(probe, 0, 0, 0, Double.MIN_VALUE, Double.MAX_VALUE, white);
		//-----------------------------------------------------------
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(probe[i][j].move){
					return board[i][j].coordinate;
				}
		return null;	
	}

	private static double alphabeta(Board[][] board, int level, int line, int row,  double alpha, double beta,  boolean white){
		//局面がゲームの終わり
		if(IfFinish.finish(board)){
			switch(IfFinish.result(board, white)){
				case 0 : return 1.0;
				case 1 : return 0.0;
				case 2 : return -1.0;
			}
		}
		//深さの限界に達したとき
		if(level >= 4){
			//評価関数の値を返す。
			switch(board[line][row].coordinate){
				case "a1" : board[line][row].importance = EvaluationFunction.evaluation(board, white)-15.0; break;				
				case "h1" : board[line][row].importance = EvaluationFunction.evaluation(board, white)-15.0; break;
				case "a8" : board[line][row].importance = EvaluationFunction.evaluation(board, white)-15.0; break;
				case "h8" : board[line][row].importance = EvaluationFunction.evaluation(board, white)-15.0; break;

				case "a2" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "b1" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "b2" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "h2" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "g1" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "g2" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "a7" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "b8" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "b7" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "h7" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "g7" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;
				case "g8" : board[line][row].importance = EvaluationFunction.evaluation(board, white)+15.0; break;

				default : board[line][row].importance = EvaluationFunction.evaluation(board, white); break;
			}
			return board[line][row].importance;
		}
		//それ以外のとき
		//重要度が高い順に探索する。
		//相手のとき（levelが奇数のとき）は重要度が低い順に探索する。
		String[] sort = new String[30];
		for(int i = 0; i < sort.length; i++){
			sort[i] = null;
		}
		double m = alpha;
		if(level % 2 == 0){
			MySort.descending(board, sort, white);
			BP:for(int i = 0; sort[i] != null; i++){
				SetBoard.setboard(board, sort[i], white);
				char[] ch = sort[i].toCharArray();
				int l = ch[1] - '1';
				int r = ch[0] - 'a';
				double v = -alphabeta(board, level+1, l, r, -beta, -m, !white);
				line = l;
				row = r;
				if(v > m){
					m = v;
					if(m >= beta){
						break BP;
					}
				}
			}
			for(int i = 0; i < 8; i++)
				for(int j = 0; j < 8; j++)
					board[i][j].move = false;
			board[line][row].move = true;
			board[line][row].importance = m;
			return board[line][row].importance;
		}

		MySort.ascending(board, sort, white);
		BP:for(int i = 0; sort[i] != null; i++){
			SetBoard.setboard(board, sort[i], white);
			char[] ch = sort[i].toCharArray();
			int l = ch[1] - '1';
			int r = ch[0] - 'a';
			double v = -alphabeta(board, level+1, l, r, -beta, -m, !white);
			line = l;
			row = r;
			if(v > m){
				m = v;
				if(m >= beta){
					break BP;
				}
			}
		}
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				board[i][j].move = false;
		board[line][row].move = true;
		board[line][row].importance = m;
		return board[line][row].importance;
	}
}
