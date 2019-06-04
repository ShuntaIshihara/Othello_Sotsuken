package Method;

public class MyEnum {
	protected enum State {
		Empty(0), //空の状態
		Black(1), //黒の状態
		White(2); //白の状態

		private final int num;

		State(int num){
			this.num = num;
		}

		protected int getEnum() {
			return num;
		}
	}
}
