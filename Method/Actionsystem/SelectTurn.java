package Method.Actionsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectTurn {
	static public boolean selectturn(){
		//黒か白かを入力させ、黒のときfalse、白のときtrueを返す。
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String str = null;
		do{
			System.out.print("Which color is my disk Brack or White? (b/w)? : "); 
			try{
				str = br.readLine();
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}

			//入力を間違えたときはもう一度やらせる
		}while(!(str.equals("b")) && !(str.equals("w")));

		if(str.equals("w")) return true;
		return false;
	}
}
