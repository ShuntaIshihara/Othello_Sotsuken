package Method;

public class OutPut extends MyEnum {
	public static void output(Board[][] board){
		System.out.println("Current Board");
		System.out.println("==========================");
		System.out.println("   a b c d e f g h");
		System.out.println();
		for(int i = 0; i < 8; i++){
			switch(i){
				case 0 : System.out.print("1 "); break;
				case 1 : System.out.print("2 "); break;
				case 2 : System.out.print("3 "); break;
				case 3 : System.out.print("4 "); break;
				case 4 : System.out.print("5 "); break;
				case 5 : System.out.print("6 "); break;
				case 6 : System.out.print("7 "); break;
				case 7 : System.out.print("8 "); break;
			}
			for(int j = 0; j < 8; j++){
				if(board[i][j].state == State.Empty){
					System.out.print(" #");
				}else if(board[i][j].state == State.Black){
					System.out.print(" X");
				}else if(board[i][j].state == State.White){
					System.out.print(" O");
				}
			}
			System.out.println();
		}
		System.out.println("# = Empty");
		System.out.println("X = Black");
		System.out.println("O = White");
		System.out.println("==========================");
	}
}
