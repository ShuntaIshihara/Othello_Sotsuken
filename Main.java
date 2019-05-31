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
				//相手の一手を入力する。
				opponent = InputOpponentMove.inputopponentmove(board, !white);

				//入力された相手の手の座標からboardを更新する。
				SetBoard.setboard(board, opponent, !white);

				//ボードの状態を表示する
				OutPut.output(board);
				
				//探索をする
				System.out.println("Start Search!!!!!");
				System.out.println("-------------------------------------------");
				my = AlphaBeta.startsearch(board, white); 
				System.out.println("-------------------------------------------");

				//自分の手を出力する
				System.out.println("I put stone at " + my);

				//boardを更新する。
 				SetBoard.setboard(board, my, white);

				//ボードの状態を表示する
				OutPut.output(board);

			}else{//先手のとき
				//探索をする
				System.out.println("Start Search!!!!!");
				System.out.println("-------------------------------------------");
				my = AlphaBeta.startsearch(board, white); 
				System.out.println("-------------------------------------------");

				//自分の手を出力する
				System.out.println("I put stone at " + my);

				//boardを更新する。
				SetBoard.setboard(board, my, white);

				//ボードの状態を表示する
				OutPut.output(board);

				//相手の一手を入力する。
				opponent = InputOpponentMove.inputopponentmove(board, !white);

				//入力された相手の手の座標からboardを更新する。
				SetBoard.setboard(board, opponent, !white);

				//ボードの状態を表示する
				OutPut.output(board);

			}
			//もし局面がゲームの終わりになったとき break;
			if(IfFinish.finish(board))
				break;
		}
	}
}
