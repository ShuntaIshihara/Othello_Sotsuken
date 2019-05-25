package Method;

public class MyEnum {
	protected enum State {
		Empty(0),
		Black(1),
		White(2);

		private final int num;

		State(int num){
			this.num = num;
		}

		protected int getEnum() {
			return num;
		}
	}
}
