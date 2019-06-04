package Method;
public class IfFinish extends MyEnum{
	public static boolean finish(Board[][] board){
		//空いている場所がない　または　置ける場所がお互いにないとき
		//試合終了
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
		//白と黒の石の数を数える。
		//自分が白の時で白が多い時は0を返す。
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

	public static boolean final_stage(Board[][] board){
		//局面が終盤戦かどうかを判定する。
		//空いているマスが15マス未満の時は終盤戦とする。
		int count = 0;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(board[i][j].state == State.Empty)
					count++;

		if(count < 15) return true;
		return false;
	}
}
