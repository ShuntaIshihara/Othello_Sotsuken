package Method;

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

	public static void setboard(Board[][] board, String coordinate, boolean white){
		//指定された座標に石を置く
		//coordinateをchar型に変換し、それをint型に変換してboardのインデックスを得る
		char[] c = coordinate.toCharArray();
		int row = c[0] - 'a';
		int line = c[1] - '1';
		
		//ひっくり返す
		if(white){
			//置かれたマスの状態を変更する。
			board[line][row].state = State.White;

			for(int i = -1; i < 1; i++){
				for(int j = -1; j < 1; j++){
					//自分のマスのときは飛ばす。
					if(i == 0 && j == 0) continue;

					if(board[line+i][row+j].state == State.Black){
						boolean check = false;
						int x = i;
						int y = j;
						while(true){
							//行が変わるとき
							if(i == -1) 	x--;
							if(i == 1)		x++;

							//列が変わるとき
							if(j == -1)		y--;
							if(j == 1)		y++;

							if(x >= 0 && x < 8 && y >= 0 && y < 8){ //配列の範囲内
								if(board[line+x][row+y].state == State.Black) 
									continue;//黒だったら隣のマスに移動
								if(board[line+x][row+y].state == State.White){
									check = true;
									break;
								}
								break;
							}else{
								break;
							}
						}

						//ひっくり返せるとき
						if(check){
							int i1 = i;
							int j1 = j;
							while(i1 == x && j1 == y){
								board[line+i1][row+j1].state = State.White;

								if(i == -1)	i1--;
								if(i == 1)	i1++;
								if(j == -1)	j1--;
								if(j == 1)	j1++;
							}
						}
					}
				}
			}
		}else{
			board[line][row].state = State.Black;
			for(int i = -1; i < 1; i++){
				for(int j = -1; j < 1; j++){
					//自分のマスのときは飛ばす。
					if(i == 0 && j == 0) continue;

					if(board[line+i][row+j].state == State.White){
						boolean check = false;
						int x = i;
						int y = j;
						while(true){
							if(i == -1)		x--;
							if(i == 1)		x++;
							if(j == -1)		y--;
							if(j == 1)		y++;

							if((line+x) >= 0 && (line+x) < 8 && (row+y) >= 0 && (row+y) < 8){ //配列の範囲内
								if(board[line+x][row+y].state == State.White) 
									continue;
								if(board[line+x][row+y].state == State.Black){
//									System.out.println(x + " " + y);
									check = true;
									break;
								}
								break;
							}else{
								break;
							}
						}

						//ひっくり返せるとき
						if(check){
							int i1 = i;
							int j1 = j;
							while(i1 != x || j1 != y){
//								System.out.println(i1 + " " + j1);
								board[line+i1][row+j1].state = State.Black;
								if(i == -1)	i1--;
								if(i == 1)	i1++;
								if(j == -1)	j1--;
								if(j == 1)	j1++;
							}
						}
//						System.out.println(x + " " + y);
					}
				}
			}
		}
	}
}
