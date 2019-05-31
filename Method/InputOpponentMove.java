package Method;

import java.util.Scanner;

public class InputOpponentMove {
	public static String inputopponentmove(Board[][] board, boolean white){
		//相手の手を入力する。

		boolean check = false;
		String str = null;
		do{
			System.out.print("Which square do you choose? : ");

			Scanner scan = new Scanner(System.in);
			str = scan.next();

BP:for(int i = 0; i < 8; i++){
	   for(int j = 0; j < 8; j++){
		   //入力された座標が正しいかチェック
		   switch(j){
			   case 0 : check = str.equals(("a"+(i+1))); break; 
			   case 1 : check = str.equals(("b"+(i+1))); break; 
			   case 2 : check = str.equals(("c"+(i+1))); break; 
			   case 3 : check = str.equals(("d"+(i+1))); break; 
			   case 4 : check = str.equals(("e"+(i+1))); break; 
			   case 5 : check = str.equals(("f"+(i+1))); break; 
			   case 6 : check = str.equals(("g"+(i+1))); break; 
			   case 7 : check = str.equals(("h"+(i+1))); break; 
			   default : break;
		   }

		   //入力された座標に石を置けるかチェック
		   if(white&&check){ //相手が白のとき
			   //置けるときはそのまま二重for文を抜ける。
			   if(board[i][j].whiteNextMove) break BP;

			   //置けないときはcheckをfalseにしてから二重for文を抜ける。
			   check = false;
			   break BP;

		   }else if(check){ //相手が黒のとき
			   if(board[i][j].blackNextMove) break BP;

			   check = false;
			   break BP;
		   }
	   }
   }

   //checkがfalseのときはメッセージを出す。
   if(!check)
	   System.err.println("You don't choose this square!\nPlease choose another one.");
		}while(!check);

		return str;
	}
}
