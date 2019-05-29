package Method;
public class IfFinish extends MyEnum{
	public static boolean finish(Board[][] board){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].state == State.Empty){
					if(board[i][j].whiteNextMove || board[i][j].blackNextMove){
						return false;
					}
				}
			}
		}
		return true;
	}

	static int result(Board[][] board, boolean white){
		int b = 0;
		int w = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].state == State.Black)
					b++;
				else if(board[i][j].state == State.White)
					w++;
			}
		}

		if(white){
			if(w > b) return 0;
			if(w < b) return 2;
		}else{
			if(b > w) return 0;
			if(b < w) return 2;
		}
		return 1;
	}
}
