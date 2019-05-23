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
				board[i][j] = new Board(coordinate, State.Empty, false, false);
			}
		}
	}
}
