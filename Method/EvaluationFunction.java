package Method;
class EvaluationFunction extends MyEnum {
	static double evaluation(Board[][] board, boolean white){
		int b = 0;
		int w = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].blackNextMove)
					b++;
				else if(board[i][j].whiteNextMove)
					w++;
			}
		}

		if(white){
			return (double)w - (double)b;
		}
		return (double)b - (double)w;
	}
}
