package Method;
class EvaluationFunction extends MyEnum {
	static double evaluation(Board[][] board, boolean white){
		int b = 0;
		int w = 0;
		if(IfFinish.final_stage(board)){//終盤のとき
			//石の多い方が有利にする
				for(int i = 0; i < 8; i++){
					for(int j = 0; j < 8; j++){
						if(board[i][j].state == State.Black)
							b++;
					else if(board[i][j].state == State.White)
							w++;
					}
				}
		}else{//終盤ではないとき
		//置ける場所が多い方が有利とする
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(board[i][j].blackNextMove)
						b++;
					if(board[i][j].whiteNextMove)
						w++;
				}
			}
		}
		if(white){
			//自分と相手の差分を返す
			return ((double)w - (double)b);
		}
		return ((double)b - (double)w);
	}
}

