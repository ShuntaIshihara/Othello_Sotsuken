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
					//黒の初期位置
					case "e4" : board[i][j] = new Board(coordinate, State.Black, false, false, 0);
								break;
					case "d5" : board[i][j] = new Board(coordinate, State.Black, false, false, 0);
								break;

								//白の初期位置
					case "d4" : board[i][j] = new Board(coordinate, State.White, false, false, 0);
								break;
					case "e5" : board[i][j] = new Board(coordinate, State.White, false, false, 0);
								break;

								//黒が打てるところ
					case "d3" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0, null, "d5", null, null);
								break;
					case "c4" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0, null, null, null, "e4");
								break;
					case "f5" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0, null, null, "d5", null);
								break;
					case "e6" : board[i][j] = new Board(coordinate, State.Empty, false, true, 0, "e4", null, null, null);
								break;

								//その他
					default : board[i][j] = new Board(coordinate, State.Empty, false, false, 0);
				}
			}
		}
	}

	public static void setboard(Board[][] board, String coordinate, boolean white){
		if(coordinate.equals("pass"))
			return;
		//指定された座標（文字列）をIndex（数字）に変換する。
		char[] ch = coordinate.toCharArray();
		int line = ch[1] - '1';
		int row = ch[0] - 'a';

		if(white){ //白のとき
			//指定された座標に石を置く
			board[line][row].state = State.White;
			board[line][row].blackNextMove = false;
			board[line][row].whiteNextMove = false;
			

			//ひっくり返す。
			if(board[line][row].up[0]*board[line][row].up[1] != 64){
				int i = -1;
				while(line+i!=board[line][row].up[0]){
					board[line+i][row].state = State.White;
					board[line+i][row].up[0] = 8;
					board[line+i][row].up[1] = 8;
					i--;
				}
			}
			if(board[line][row].up_left[0]*board[line][row].up_left[1] != 64){
				int i = -1;
				int j = -1; 
				while(line+i!=board[line][row].up_left[0] || row+j!=board[line][row].up_left[1]){
					board[line+i][row+j].state = State.White;
					board[line+i][row+j].up_left[0] = 8;
					board[line+i][row+j].up_left[1] = 8;
					i--;
					j--;
				}
			}
			if(board[line][row].up_right[0]*board[line][row].up_right[1] != 64){
				int i = -1;
				int j = 1; 
				while(line+i!=board[line][row].up_right[0] || row+j!=board[line][row].up_right[1]){
					board[line+i][row+j].state = State.White;
					board[line+i][row+j].up_right[0] = 8;
					board[line+i][row+j].up_right[1] = 8;
					i--;
					j++;
				}
			}
			if(board[line][row].left[0]*board[line][row].left[1] != 64){
				int j = -1; 
				while(row+j!=board[line][row].left[1]){
					board[line][row+j].state = State.White;
					board[line][row+j].left[0] = 8;
					board[line][row+j].left[1] = 8;
					j--;
				}
			}
			if(board[line][row].right[0]*board[line][row].right[1] != 64){
				int j = 1; 
				while(row+j!=board[line][row].right[1]){
					board[line][row+j].state = State.White;
					board[line][row+j].right[0] = 8;
					board[line][row+j].right[1] = 8;
					j++;
				}
			}
			if(board[line][row].down[0]*board[line][row].down[1] != 64){
				int i = 1; 
				while(line+i!=board[line][row].down[0]){
					board[line+i][row].state = State.White;
					board[line+i][row].down[0] = 8;
					board[line+i][row].down[1] = 8;
					i++;
				}
			}
			if(board[line][row].down_left[0]*board[line][row].down_left[1] != 64){
				int i = 1;
				int j = -1; 
				while(line+i!=board[line][row].down_left[0] || row+j!=board[line][row].down_left[1]){
					board[line+i][row+j].state = State.White;
					board[line+i][row+j].down_left[0] = 8;
					board[line+i][row+j].down_left[1] = 8;
					i++;
					j--;
				}
			}
			if(board[line][row].down_right[0]*board[line][row].down_right[1] != 64){
				int i = 1;
				int j = 1; 
				while(line+i!=board[line][row].down_right[0] || row+j!=board[line][row].down_right[1]){
					board[line+i][row+j].state = State.White;
					board[line+i][row+j].down_right[0] = 8;
					board[line+i][row+j].down_right[1] = 8;
					i++;
					j++;
				}
			}
			board[line][row].up[0] = 8;			
			board[line][row].up[1] = 8;
			board[line][row].up_left[0] = 8;
			board[line][row].up_left[1] = 8;
			board[line][row].up_right[0] = 8;
			board[line][row].up_right[1] = 8;
			board[line][row].left[0] = 8;
			board[line][row].left[1] = 8;
			board[line][row].right[0] = 8;
			board[line][row].right[1] = 8;
			board[line][row].down[0] = 8;
			board[line][row].down[1] = 8;
			board[line][row].down_left[0] = 8;
			board[line][row].down_left[1] = 8;
			board[line][row].down_right[0] = 8;
			board[line][row].down_right[1] = 8;

		}else{ //黒のとき
			//指定された座標に石を置く
			board[line][row].state = State.Black;
			board[line][row].blackNextMove = false;
			board[line][row].whiteNextMove = false;
			
			//ひっくり返す。
			if(board[line][row].up[0]*board[line][row].up[1] != 64){
				int i = -1;
				while(line+i!=board[line][row].up[0]){
					board[line+i][row].state = State.Black;
					board[line+i][row].up[0] = 8;
					board[line+i][row].up[1] = 8;
					i--;
				}
			}
			if(board[line][row].up_left[0]*board[line][row].up_left[1] != 64){
				int i = -1;
				int j = -1; 
				while(line+i!=board[line][row].up_left[0] || row+j!=board[line][row].up_left[1]){
					board[line+i][row+j].state = State.Black;
					board[line+i][row+j].up_left[0] = 8;
					board[line+i][row+j].up_left[1] = 8;
					i--;
					j--;
				}
			}
			if(board[line][row].up_right[0]*board[line][row].up_right[1] != 64){
				int i = -1;
				int j = 1; 
				while(line+i!=board[line][row].up_right[0] || row+j!=board[line][row].up_right[1]){
					board[line+i][row+j].state = State.Black;
					board[line+i][row+j].up_right[0] = 8;
					board[line+i][row+j].up_right[1] = 8;
					i--;
					j++;
				}
			}
			if(board[line][row].left[0]*board[line][row].left[1] != 64){
				int j = -1; 
				while(row+j!=board[line][row].left[1]){
					board[line][row+j].state = State.Black;
					board[line][row+j].left[0] = 8;
					board[line][row+j].left[1] = 8;
					j--;
				}
			}
			if(board[line][row].right[0]*board[line][row].right[1] != 64){
				int j = 1; 
				while(row+j!=board[line][row].right[1]){
					board[line][row+j].state = State.Black;
					board[line][row+j].right[0] = 8;
					board[line][row+j].right[1] = 8;
					j++;
				}
			}
			if(board[line][row].down[0]*board[line][row].down[1] != 64){
				int i = 1; 
				while(line+i!=board[line][row].down[0]){
					board[line+i][row].state = State.Black;
					board[line+i][row].down[0] = 8;
					board[line+i][row].down[1] = 8;
					i++;
				}
			}
			if(board[line][row].down_left[0]*board[line][row].down_left[1] != 64){
				int i = 1;
				int j = -1; 
				while(line+i!=board[line][row].down_left[0] || row+j!=board[line][row].down_left[1]){
					board[line+i][row+j].state = State.Black;
					board[line+i][row+j].down_left[0] = 8;
					board[line+i][row+j].down_left[1] = 8;
					i++;
					j--;
				}
			}
			if(board[line][row].down_right[0]*board[line][row].down_right[1] != 64){
				int i = 1;
				int j = 1; 
				while(line+i!=board[line][row].down_right[0] || row+j!=board[line][row].down_right[1]){
					board[line+i][row+j].state = State.Black;
					board[line+i][row+j].down_right[0] = 8;
					board[line+i][row+j].down_right[1] = 8;
					i++;
					j++;
				}
			}
			board[line][row].up[0] = 8;			
			board[line][row].up[1] = 8;
			board[line][row].up_left[0] = 8;
			board[line][row].up_left[1] = 8;
			board[line][row].up_right[0] = 8;
			board[line][row].up_right[1] = 8;
			board[line][row].left[0] = 8;
			board[line][row].left[1] = 8;
			board[line][row].right[0] = 8;
			board[line][row].right[1] = 8;
			board[line][row].down[0] = 8;
			board[line][row].down[1] = 8;
			board[line][row].down_left[0] = 8;
			board[line][row].down_left[1] = 8;
			board[line][row].down_right[0] = 8;
			board[line][row].down_right[1] = 8;
		}
		//boardを更新する。
		renew(board);
	}

	private static void renew(Board[][] board){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].state == State.Empty){
					renew(board, i, j);	
				}
			}
		}
	}

	private static void renew(Board[][] board, int line, int row){
		board[line][row].blackNextMove = false;
		board[line][row].whiteNextMove = false;
		board[line][row].up[0] = 8;			
		board[line][row].up[1] = 8;
		board[line][row].up_left[0] = 8;
		board[line][row].up_left[1] = 8;
		board[line][row].up_right[0] = 8;
		board[line][row].up_right[1] = 8;
		board[line][row].left[0] = 8;
		board[line][row].left[1] = 8;
		board[line][row].right[0] = 8;
		board[line][row].right[1] = 8;
		board[line][row].down[0] = 8;
		board[line][row].down[1] = 8;
		board[line][row].down_left[0] = 8;
		board[line][row].down_left[1] = 8;
		board[line][row].down_right[0] = 8;
		board[line][row].down_right[1] = 8;

		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				//自分のマスのときは飛ばす。
				if(i == 0 && j == 0) continue;

				if(line+i >= 0 && line+i < 8 && row+j >= 0 && row+j < 8){	
					if(board[line+i][row+j].state == State.Empty){
						continue;
					}else if(board[line+i][row+j].state == State.White){
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
									check = true;
									if(i == -1){
										if(j == -1){
											board[line][row].up_left[0] = line+x;
											board[line][row].up_left[1] = row+y;
										}
										if(j == 0){
											board[line][row].up[0] = line+x;
											board[line][row].up[1] = row+y;
										}
										if(j == 1){
											board[line][row].up_right[0] = line+x;
											board[line][row].up_right[1] = row+y;
										}
									}else if(i == 0){
										if(j == -1){
											board[line][row].left[0] = line+x;
											board[line][row].left[1] = row+y;
										}
										if(j == 1){
											board[line][row].right[0] = line+x;
											board[line][row].right[1] = row+y;
										}
									}else if(i == 1){
										if(j == -1){
											board[line][row].down_left[0] = line+x;
											board[line][row].down_left[1] = row+y;
										}
										if(j == 0){
											board[line][row].down[0] = line+x;
											board[line][row].down[1] = row+y;
										}
										if(j == 1){
											board[line][row].down_right[0] = line+x;
											board[line][row].down_right[1] = row+y;
										}
									}
								}
								break;
							}else{
								break;
							}
						}
						if(check){
							board[line][row].blackNextMove = true;
							board[line][row].whiteNextMove = false;
						}
					}else if(board[line+i][row+j].state == State.Black){
						boolean check = false;
						int x = i;
						int y = j;
						while(true){
							if(i == -1)		x--;
							if(i == 1)		x++;
							if(j == -1)		y--;
							if(j == 1)		y++;

							if((line+x) >= 0 && (line+x) < 8 && (row+y) >= 0 && (row+y) < 8){ //配列の範囲内
								
								if(board[line+x][row+y].state == State.Black) 
									continue;
								if(board[line+x][row+y].state == State.White){
									check = true;
									if(i == -1){
										if(j == -1){
											board[line][row].up_left[0] = line+x;
											board[line][row].up_left[1] = row+y;
										}
										if(j == 0){
											board[line][row].up[0] = line+x;
											board[line][row].up[1] = row+y;
										}
										if(j == 1){
											board[line][row].up_right[0] = line+x;
											board[line][row].up_right[1] = row+y;
										}
									}else if(i == 0){
										if(j == -1){
											board[line][row].left[0] = line+x;
											board[line][row].left[1] = row+y;
										}
										if(j == 1){
											board[line][row].right[0] = line+x;
											board[line][row].right[1] = row+y;
										}
									}else if(i == 1){
										if(j == -1){
											board[line][row].down_left[0] = line+x;
											board[line][row].down_left[1] = row+y;
										}
										if(j == 0){
											board[line][row].down[0] = line+x;
											board[line][row].down[1] = row+y;
										}
										if(j == 1){
											board[line][row].down_right[0] = line+x;
											board[line][row].down_right[1] = row+y;
										}
									}
								}
								break;
							}else{
								break;
							}
						}
						if(check){
							board[line][row].blackNextMove = false;
							board[line][row].whiteNextMove = true;
						}
					}
				}
			}
		}
	}
}
