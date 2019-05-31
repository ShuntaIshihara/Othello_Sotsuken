package Method;
class MySort extends MyEnum {
	static void ascending(Board[][] board, String[] sort, boolean white){
		int k = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(white){
					if(board[i][j].state == State.Empty && board[i][j].whiteNextMove){
						sort[k] = board[i][j].coordinate; 
						k++;
					}
				}else{
					if(board[i][j].state == State.Empty && board[i][j].blackNextMove){
						sort[k] = board[i][j].coordinate;
						k++; 
					}

				}
			}
		}
		
		for(int i = 0; sort[i] != null; i++){
			char[] ch = sort[i].toCharArray();
			int l = ch[1] - '1';
			int r = ch[0] - 'a';
			int s = i;
			double min = board[l][r].importance;
			for(int j = i; sort[j] != null; j++){
				ch = sort[j].toCharArray();
				l = ch[1] - '1';
				r = ch[0] - 'a';
				if(board[l][r].importance < min){
					min = board[l][r].importance;
					k = j;
				}
			}
			String w = sort[i];
			sort[i] = sort[s];
			sort[s] = w;
		}
	}

	static void descending(Board[][] board, String[] sort, boolean white){
		int k = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(white){
					if(board[i][j].state == State.Empty && board[i][j].whiteNextMove){
						sort[k] = board[i][j].coordinate;
						k++;
					}
				}else{
					if(board[i][j].state == State.Empty && board[i][j].blackNextMove){
						sort[k] = board[i][j].coordinate; 
						k++;
					}
				}
			}
		}

		for(int i = 0; sort[i] != null; i++){
			char[] ch = sort[i].toCharArray();
			int l = ch[1] - '1';
			int r = ch[0] - 'a';
			int s = i;
			double max = board[l][r].importance;
			for(int j = i; sort[j] != null; j++){
				ch = sort[j].toCharArray();
				l = ch[1] - '1';
				r = ch[0] - 'a';
				if(board[l][r].importance > max){
					max = board[l][r].importance;
					k = j;
				}
			}
			String w = sort[i];
			sort[i] = sort[s];
			sort[s] = w;
		}
	}
}
