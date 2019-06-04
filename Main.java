import Method.*;

class Main extends MyEnum{
	public static void main(String[] args){
		Board[][] board = new Board[8][8];
		//boardの状態を初期状態にセットする。
		SetBoard.setboard(board);

OutPut.output(board);
		//先手（黒）か後手（白）を選択する。
		//先手のとき false
		//後手のとき true
		boolean white = SelectTurn.selectturn();

		//SelectTurnテスト用コード
//		System.out.println(white);

		String opponent = "";
		String my = "";

		while(true){
			//後手のとき
			if(white){

				boolean check = false;
				//相手の一手を入力する。
				BP:for(int i = 0; i < 8; i++)
					for(int j = 0; j < 8; j++)
						if(board[i][j].blackNextMove){
							check = true;
							break BP;
						}
				if(check){
				opponent = InputOpponentMove.inputopponentmove(board, !white);
				}else{
					System.out.println();
					System.out.println("You can not put anywhere.....");
					System.out.println();
				}

				//入力された相手の手の座標からboardを更新する。
				SetBoard.setboard(board, opponent, !white);

				//ボードの状態を表示する
				OutPut.output(board);
				
				//探索をする
				System.out.println("Start Search!!!!!");
				check = false;
				BP:for(int i = 0; i < 8; i++)
					for(int j = 0; j < 8; j++)
						if(board[i][j].whiteNextMove){
							check = true;
							break BP;
						}
				if(check){
					my = AlphaBeta.startsearch(board, white); 


				//自分の手を出力する
				System.out.println();
				System.out.println("^^^^^^^^^^^^^^^^^^^^");
				System.out.println("I put stone at " + my);
				System.out.println("vvvvvvvvvvvvvvvvvvvv");
				System.out.println();

				//boardを更新する。
 				SetBoard.setboard(board, my, white);
				}else{
					System.out.println("I can't move........");
				}

				//ボードの状態を表示する
				OutPut.output(board);

			}else{//先手のとき
				//探索をする
				System.out.println("Start Search!!!!!");
				boolean check = false;
				BP:for(int i = 0; i < 8; i++)
					for(int j = 0; j < 8; j++)
						if(board[i][j].blackNextMove){
							check = true;
							break BP;
						}
				if(check){
					my = AlphaBeta.startsearch(board, white); 


				//自分の手を出力する
				System.out.println();
				System.out.println("^^^^^^^^^^^^^^^^^^^^");
				System.out.println("I put stone at " + my);
				System.out.println("vvvvvvvvvvvvvvvvvvvv");
				System.out.println();

				//boardを更新する。
 				SetBoard.setboard(board, my, white);
				}else{
					System.out.println("I can't move........");
				}

				//ボードの状態を表示する
				OutPut.output(board);

				//相手の一手を入力する。
				check = false;
				BP:for(int i = 0; i < 8; i++)
	   				for(int j = 0; j < 8; j++)
						if(board[i][j].whiteNextMove){
							check = true;
							break BP;
						}
				if(check){
				opponent = InputOpponentMove.inputopponentmove(board, !white);
				//入力された相手の手の座標からboardを更新する。
				SetBoard.setboard(board, opponent, !white);

				//ボードの状態を表示する
				OutPut.output(board);

				}else{
					System.out.println();
					System.out.println("You can not put anywhere.....");
					System.out.println();
				}

				
			}
			//もし局面がゲームの終わりになったとき break;
			if(IfFinish.finish(board))
				break;
		}
	}
}
