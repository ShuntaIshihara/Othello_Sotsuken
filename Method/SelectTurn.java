package Method;

import java.util.Scanner;

public class SelectTurn {
	static public boolean selectturn(){
		//黒か白かを入力させ、黒のときfalse、白のときtrueを返す。
		String str = null;
		boolean check = true;
		do{
			check = true;
			System.out.print("Which color is my disk Brack or White? (b/w)? : "); 

			Scanner scan = new Scanner(System.in);
			str = scan.next();

			if(!(str.equals("b")) && !(str.equals("w"))){
				System.err.println("Wrong way of type!");
				check = false;
			}
			//入力を間違えたときはもう一度やらせる
		}while(!check);

		if(str.equals("w")) return true;
		return false;
	}
}
