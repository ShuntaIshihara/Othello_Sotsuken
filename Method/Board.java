package Method;

public class Board extends MyEnum{
	public String coordinate;			//座標
	public State state;				//マスの状態
	public boolean whiteNextMove;		//白が打てるかどうか
	public boolean blackNextMove;		//黒が打てるかどうか
	public double importance;				//マスの重要性

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
	}
}
