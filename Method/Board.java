package Method;

public class Board extends MyEnum{
	public String coordinate;			//座標
	public State state;				//マスの状態
	public boolean whiteNextMove;		//白が打てるかどうか
	public boolean blackNextMove;		//黒が打てるかどうか
	public double importance;				//マスの重要性
	public String up;				//上のマスのどこまでひっくり返せるか	
	public String up_left;			//左上のマスのどこまでひっくり返せるか
	public String up_right;			//右上のマスのどこまでひっくり返せるか
	public String left;				//左のマスのどこまでひっくり返せるか
	public String right;			//右のマスのどこまでひっくり返せるか
	public String down;				//下のマスのどこまでひっくり返せるか
	public String down_left;		//左下のマスのどこまでひっくり返せるか
	public String down_right;		//右下のマスのどこまでひっくり返せるか

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		up = null;
		up_left = null;
		up_right = null;
		left = null;
		right = null;
		down = null;
		down_left = null;
		down_right = null;
	}

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance, String up, String down, String left, String right){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		this.up = up; 
		up_left = null;
		up_right = null;
		this.left = left;
		this.right = right;
		this.down = down;
		down_left = null;
		down_right = null;
	}
}
