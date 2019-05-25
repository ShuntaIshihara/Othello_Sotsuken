
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOpponentMove {
	public static String(){
		//相手の手を入力する。
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String str = null;
		do{
			System.out.print("Which coordinate did my opponent choose? : ");
			try{
				str = br.readLine();
				br.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}while();
	}
}
