import Method.*;

class Main extends MyEnum{
	public static void main(String[] args){
		Board[][] board = new Board[8][8];
		//boardの状態を初期状態にセットする。
		SetBoard.setboard(board);

		//先手（黒）か後手（白）を選択する。
		//先手のとき false
		//後手のとき true
		boolean white = SelectTurn.selectturn();

		//SelectTurnテスト用コード
//		System.out.println(white);

		String opponent = "";

		//while(true){

			//後手のとき
//			if(white){
				//相手の一手を入力する。
				opponent = InputOpponentMove.inputopponentmove(board, !white);
				//InputOpponentMoveテスト用コード
//				System.out.println(opponent);

				//入力された相手の手の座標からboardを更新する。
				SetBoard.setboard(board, opponent, !white);
				
				//---------------------------------------------
				//AlphaBetaメソッドを呼び出して最適解を見つける。

				//---------------------------------------------

				//---------------------------------------------
				//自分の手を出力する

				//---------------------------------------------

				//---------------------------------------------
				//boardを更新する。
//				SetBoard.setboard(board, my, white);
				//---------------------------------------------
//			}else{//先手のとき
								
				//---------------------------------------------
				//AlphaBetaメソッドを呼び出して最適解を見つける。

				//---------------------------------------------

				//---------------------------------------------
				//自分の手を出力する

				//---------------------------------------------

				//---------------------------------------------
				//boardを更新する。

				//---------------------------------------------

				//相手の一手を入力する。
//				opponent = InputOpponentMove.inputopponentmove();
				//入力された相手の手の座標からboardを更新する。
//				Setboard.setboard(board, opponent);
//			}
			//--------------------------------------------
			//もし局面がゲームの終わりになったとき break;

			//--------------------------------------------
		//}
		
		//テスト用コード（入力とboardの初期化）
		
		System.out.println("boardの状態 座標を返す");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++)
				System.out.print(" " + board[i][j].coordinate);
			System.out.println();
		}
		System.out.println();
		System.out.println("黒と白の初期位置");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j].state == State.Black)
					System.out.println(board[i][j].coordinate + " = black");
				if(board[i][j].state == State.White)
					System.out.println(board[i][j].coordinate + " = white");
			}
		}
		System.out.println();
		System.out.println("黒と白が打てるところ");
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				if(board[i][j].blackNextMove)
					System.out.println("black can move to " + board[i][j].coordinate);
				if(board[i][j].whiteNextMove)
					System.out.println("white can move to " + board[i][j].coordinate);
			}

	}
}
