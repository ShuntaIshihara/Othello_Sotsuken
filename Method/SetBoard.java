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
		//指定された座標（文字列）をIndex（数字）に変換する。
		char[] ch = coordinate.toCharArray();
		int line = ch[1] - '1';
		int row = ch[0] - 'a';

		if(white){ //白のとき
			//指定された座標に石を置く
			board[line][row].state = State.White;

			//ひっくり返す。
			if(board[line][row].up != null){
				int i = -1;
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x){
					board[line+i][row].state = State.White;
					i--;
				}
			}
			if(board[line][row].up_left != null){
				int i = -1;
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i--;
					j--;
				}
			}
			if(board[line][row].up_right != null){
				int i = -1;
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i--;
					j++;
				}
			}
			if(board[line][row].left != null){
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(j!=y){
					board[line][row+j].state = State.White;
					j--;
				}
			}
			if(board[line][row].right != null){
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(j!=y){
					board[line][row+j].state = State.White;
					j++;
				}
			}
			if(board[line][row].down != null){
				int i = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x){
					board[line+i][row].state = State.White;
					i++;
				}
			}
			if(board[line][row].down_left != null){
				int i = 1;
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i++;
					j--;
				}
			}
			if(board[line][row].down_right != null){
				int i = 1;
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i++;
					j++;
				}
			}
		}else{ //黒のとき
			//指定された座標に石を置く
			board[line][row].state = State.White;

			//ひっくり返す。
			if(board[line][row].up != null){
				int i = -1;
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x){
					board[line+i][row].state = State.White;
					i--;
				}
			}
			if(board[line][row].up_left != null){
				int i = -1;
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i--;
					j--;
				}
			}
			if(board[line][row].up_right != null){
				int i = -1;
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i--;
					j++;
				}
			}
			if(board[line][row].left != null){
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(j!=y){
					board[line][row+j].state = State.White;
					j--;
				}
			}
			if(board[line][row].right != null){
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(j!=y){
					board[line][row+j].state = State.White;
					j++;
				}
			}
			if(board[line][row].down != null){
				int i = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x){
					board[line+i][row].state = State.White;
					i++;
				}
			}
			if(board[line][row].down_left != null){
				int i = 1;
				int j = -1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i++;
					j--;
				}
			}
			if(board[line][row].down_right != null){
				int i = 1;
				int j = 1; 
				ch = board[line][row].up.toCharArray();
				int x = ch[1] - '1';
				int y = ch[0] - 'a';
				while(i!=x || j!=y){
					board[line+i][row+j].state = State.White;
					i++;
					j++;
				}
			}

		}

		//boardを更新する。
		renew(board);
	}
	
	private static void renew(Board[][] board){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				renew(board, i, j);	
			}
		}
	}

	private static void renew(Board[][] board, int line, int row){
		for(int i = -1; i < 1; i++){
			for(int j = -1; j < 1; j++){
				//自分のマスのときは飛ばす。
				if(i == 0 && j == 0) continue;

				if(board[line+i][row+j].state == State.Empty){
					break;
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
								char[] c1 = Character.toChars((row+y) +'a');
								char[] c2 = Character.toChars((line+x)+'1');
								String str1 = new String(c1);
								String str2 = new String(c2);
								StringBuffer bf = new StringBuffer();
								bf.append(str1);
								bf.append(str2);
								if(i == -1){
									if(j == -1) board[line][row].up_left = bf.toString();
									if(j == 0)  board[line][row].up = bf.toString();
									if(j == 1)  board[line][row].up_right = bf.toString();
								}else if(i == 0){
									if(j == -1) board[line][row].left = bf.toString();
									if(j == 1)  board[line][row].right = bf.toString();;
								}else if(i == 1){
									if(j == -1) board[line][row].down_left = bf.toString();
									if(j == 0)  board[line][row].down = bf.toString();
									if(j == 1)  board[line][row].down_right = bf.toString();
								}
								break;
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
								char[] c1 = Character.toChars((row+y)+'a');
								char[] c2 = Character.toChars((line+x)+'1');
								String str1 = new String(c1);
								String str2 = new String(c2);
								StringBuffer bf = new StringBuffer();
								bf.append(str1);
								bf.append(str2);
								if(i == -1){
									if(j == -1) board[line][row].up_left = bf.toString();
									if(j == 0)  board[line][row].up = bf.toString();
									if(j == 1)  board[line][row].up_right = bf.toString();
								}else if(i == 0){
									if(j == -1) board[line][row].left = bf.toString();
									if(j == 1)  board[line][row].right = bf.toString();
								}else if(i == 1){
									if(j == -1) board[line][row].down_left = bf.toString();
									if(j == 0)  board[line][row].down = bf.toString();
									if(j == 1)  board[line][row].down_right = bf.toString();
								}
								break;
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
