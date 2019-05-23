class Board extends MyEnum{
	String coordinate;			//座標
	State state;				//マスの状態
	boolean whiteNextMove;		//白が打てるかどうか
	boolean blackNextMove;		//黒が打てるかどうか
	int important;				//マスの重要性

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		int important = 0; //後で重要度を設定する。
	}
}
