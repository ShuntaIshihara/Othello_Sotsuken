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
	public boolean move = false;

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		up[0] = 8; up[1] = 8;
		up_left[0] = 8; up_left[1] = 8;
		up_right[0] = 8; up_right[1] = 8;
		left[0] = 8; left[1] = 8;
		right[0] = 8; right[1] = 8;
		down[0] = 8; down[1] = 8;
		down_left[0] = 8; down_left[1] = 8;
		down_right[0] = 8; down_right[1] = 8;
	}

/*	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance, String up, String down, String left, String right){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		if(up != null){
			char[] ch = up.toCharArray();
			this.up[0] = ch[1] - '1';
			this.up[1] = ch[0] - 'a';
		}else{
			this.up[0] = 8; this.up[1] = 8;
		} 
		up_left[0] = 8; up_left[1] = 8;
		up_right[0] = 8; up_right[1] = 8;
		if(left != null){
			char[] ch = left.toCharArray();
			this.left[0] = ch[1] - '1';
			this.left[1] = ch[0] - 'a';
		}else{
			this.left[0] = 8; this.left[1] = 8;
		}
		if(right != null){
			char[] ch = right.toCharArray();
			this.right[0] = ch[1] - '1';
			this.right[1] = ch[0] - 'a';
		}else{
			this.right[0] = 8; this.right[1] = 8;
		}
		if(down != null){
			char[] ch = down.toCharArray();
			this.down[0] = ch[1] - '1';
			this.down[1] = ch[0] - 'a';
		}else{
			this.down[0] = 8; this.down[1] = 8;
		}
		down_left[0] = 8; down_left[1] = 8;
		down_right[0] = 8; down_right[1] = 8;
	}*/
	//使わなかった↑↑↑

	Board(String coordinate, State state, boolean whiteNextMove, boolean blackNextMove, double importance, int up0, int up1, int up_left0, int up_left1, int up_right0, int up_right1, int left0, int left1, int right0, int right1, int down0, int down1, int down_left0, int down_left1, int down_right0, int down_right1){
		this.coordinate = coordinate;
		this.state = state;
		this.whiteNextMove = whiteNextMove;
		this.blackNextMove = blackNextMove;
		this.importance = importance;
		up[0] = up0;
		up[1] = up1;
		up_left[0] = up_left0;
		up_left[1] = up_left1;
		up_right[0] = up_right0;
		up_right[1] = up_right1;
		left[0] = left0;
		left[1] = left1;
		right[0] = right0;
		right[1] = right1;
		down[0] = down0;
		down[1] = down1;
		down_left[0] = down_left0;
		down_left[1] = down_left1;
		down_right[0] = down_right0;
		down_right[1] = down_right1;
	}
}
