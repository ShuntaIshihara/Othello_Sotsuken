package Method.BoardData;

public class Board extends MyEnum{
	public String coordinate;			//座標
	public State state;				//マスの状態
	public boolean whiteNextMove;		//白が打てるかどうか
	public boolean blackNextMove;		//黒が打てるかどうか
	public int important;				//マスの重要性

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		int important = 0; //後で重要度を設定する。
	}
}
