package Method;

public class AlphaBeta {
	public static String startsearch(Board[][] board, boolean white){
		//角が取れるときはとにかく取る
		if(white){
			if(board[0][0].whiteNextMove) return board[0][0].coordinate;
			if(board[0][7].whiteNextMove) return board[0][7].coordinate;
			if(board[7][0].whiteNextMove) return board[7][0].coordinate;
			if(board[7][7].whiteNextMove) return board[7][7].coordinate;
		}else{
			if(board[0][0].blackNextMove) return board[0][0].coordinate;
			if(board[0][7].blackNextMove) return board[0][7].coordinate;
			if(board[7][0].blackNextMove) return board[7][0].coordinate;
			if(board[7][7].blackNextMove) return board[7][7].coordinate;
		}

		//角が取れないとき
		//-----------------------------------------------------------
		//alphabetaメソッドを呼び出す。
		double k = alphabeta(board, 0, 0, 0, Double.MIN_VALUE, Double.MAX_VALUE, white);
		//-----------------------------------------------------------
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(board[i][j].move){
					/*if(!(i == 0 && j == 1) &&		//角の周りを取ろうとしたら避けるようにする。
						!(i == 0 && j == 6) &&
						!(i == 1 && j == 0) &&
						!(i == 1 && j == 1) &&
						!(i == 1 && j == 6) &&
						!(i == 1 && j == 7) &&
						!(i == 6 && j == 0) &&
						!(i == 6 && j == 6) &&
						!(i == 6 && j == 7) &&
						!(i == 7 && j == 1) &&
						!(i == 7 && j == 6))*/
						return board[i][j].coordinate;
				}
		/*for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				if(!(i == 0 && j == 1) &&			//角の周り以外で置けるところにとにかく置く
						!(i == 0 && j == 6) &&
						!(i == 1 && j == 0) &&
						!(i == 1 && j == 1) &&
						!(i == 1 && j == 6) &&
						!(i == 1 && j == 7) &&
						!(i == 6 && j == 0) &&
						!(i == 6 && j == 6) &&
						!(i == 6 && j == 7) &&
						!(i == 7 && j == 1) &&
						!(i == 7 && j == 6)){
					if(white){
						if(board[i][j].whiteNextMove) return board[i][j].coordinate;
					}else{
						if(board[i][j].blackNextMove) return board[i][j].coordinate;
					}
				}
			}

		/*for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
					if(white){ //角の周りしかおけないときは仕方なくおく
						if(board[i][j].whiteNextMove) return board[i][j].coordinate;
					}else{
						if(board[i][j].blackNextMove) return board[i][j].coordinate;
					}
				}*/
			

		return null; //これが返されることはない（と思う...）
	}

	private static double alphabeta(Board[][] board, int level, int line, int row,  double alpha, double beta,  boolean white){

		//局面がゲームの終わり
		if(IfFinish.finish(board)){
			switch(IfFinish.result(board, white)){
				//IfFinish.resultはそれぞれ
				//自分が価値のとき　0
				//引き分けのとき　　1
				//まけのとき　　　　2
				//を返す。
				case 0 : return 1.0;
				case 1 : return 0.0;
				case 2 : return -1.0;
			}
		}
		//深さの限界に達したとき
		if(level >= 4){
			//評価関数の値を返す。
			return EvaluationFunction.evaluation(board, white);
		}
		//それ以外のとき
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


		//重要度が高い順に探索する。
		//相手のとき（levelが奇数のとき）は重要度が低い順に探索する。
		String[] sort = new String[30];
		for(int i = 0; i < sort.length; i++){
			sort[i] = null;
		}
		double m = alpha;
		if(level % 2 == 0){		//自分のとき
			MySort.descending(probe, sort, white);
			BP:for(int i = 0; sort[i] != null; i++){
				SetBoard.setboard(probe, sort[i], white);
				char[] ch = sort[i].toCharArray();
				int l = ch[1] - '1';
				int r = ch[0] - 'a';
				double v = -alphabeta(probe, level+1, l, r, -beta, -m, !white);
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
					board[i][j].move = false; //最適解を一つだけ求めるために他のものはfalseにしておく
			board[line][row].move = true;		//最適解にtrueを入れる。
			board[line][row].importance = m;
			return board[line][row].importance;
		}

		//相手のとき
		MySort.ascending(probe, sort, white);
		BP:for(int i = 0; sort[i] != null; i++){
			SetBoard.setboard(probe, sort[i], white);
			char[] ch = sort[i].toCharArray();
			int l = ch[1] - '1';
			int r = ch[0] - 'a';
			double v = -alphabeta(probe, level+1, l, r, -beta, -m, !white);
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
