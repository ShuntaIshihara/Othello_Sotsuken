package Method.BoardData;

public class SetBoard extends MyEnum{
	static public void setboard(Board[][] board){
		String coordinate = "";
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				//座標を自動で入力するようにする。
				switch(j){
					case 0 : coordinate = "a" + (i+1); break;
					case 1 : coordinate = "b" + (i+1); break;					
					case 2 : coordinate = "c" + (i+1); break;
					case 3 : coordinate = "d" + (i+1); break;
					case 4 : coordinate = "e" + (i+1); break;
					case 5 : coordinate = "f" + (i+1); break;
					case 6 : coordinate = "g" + (i+1); break;
					case 7 : coordinate = "h" + (i+1); break;
				}
				//とりあえず今はこれ
				//あとで初期状態と初期状態のときに打てる場所を探すようにする。
				switch(coordinate){
					//隅の重要度
					case "a1" : board[i][j] = new Board(coordinate, State.Empty, false, false, 10.0);
								break;
					case "h1" : board[i][j] = new Board(coordinate, State.Empty, false, false, 10.0);
								break;
					case "a8" : board[i][j] = new Board(coordinate, State.Empty, false, false, 10.0);
								break;
					case "h8" : board[i][j] = new Board(coordinate, State.Empty, false, false, 10.0);
								break;

					//X,Cの重要度
					case "b1" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "b2" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "b7" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "b8" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "g1" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "g2" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "g7" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "g8" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "a2" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "a7" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "h2" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;
					case "h7" : board[i][j] = new Board(coordinate, State.Empty, false, false, -10.0); 
								break;

					//黒の初期位置
					case "e4" :	board[i][j] = new Board(coordinate, State.Black, false, false, 0);
								break;
					case "d5" : board[i][j] = new Board(coordinate, State.Black, false, false, 0);
								break;

					//白の初期位置
					case "d4" : board[i][j] = new Board(coordinate, State.White, false, false, 0);
								break;
					case "e5" : board[i][j] = new Board(coordinate, State.White, false, false, 0);
								break;

					//黒が打てるところ
					case "d3" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0);
								break;
					case "c4" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0);
								break;
					case "f5" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0);
								break;
					case "e6" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0);
								break;

					//白が打てるところ
					case "e3" : board[i][j] = new Board(coordinate, State.Empty, true, false, 0);
								break;
					case "f4" : board[i][j] = new Board(coordinate, State.Empty, true, false, 0);
								break;
					case "d6" : board[i][j] = new Board(coordinate, State.Empty, true, false, 0);
								break;
					case "c5" : board[i][j] = new Board(coordinate, State.Empty, true, false, 0);
								break;

					//その他
					default : board[i][j] = new Board(coordinate, State.Empty, false, false, 0);
				}
			}
		}
	}
}
