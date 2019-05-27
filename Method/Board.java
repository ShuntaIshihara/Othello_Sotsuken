package Method;

public class Board extends MyEnum{
	public String coordinate;			//座標
	public State state;				//マスの状態
	public boolean whiteNextMove;		//白が打てるかどうか
	public boolean blackNextMove;		//黒が打てるかどうか
	public double importance;				//マスの重要性
	public int[] up = new int[2];	//上のマスのどこまでひっくり返せるか	
	public int[] up_left = new int[2];	//左上のマスのどこまでひっくり返せるか
	public int[] up_right = new int[2];		//右上のマスのどこまでひっくり返せるか
	public int[] left = new int[2];				//左のマスのどこまでひっくり返せるか
	public int[] right = new int[2];			//右のマスのどこまでひっくり返せるか
	public int[] down = new int[2];				//下のマスのどこまでひっくり返せるか
	public int[] down_left = new int[2];	//左下のマスのどこまでひっくり返せるか
	public int[] down_right = new int[2];	//右下のマスのどこまでひっくり返せるか

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		up[0] = null; up[1] = null;
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
