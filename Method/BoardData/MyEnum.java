class MyEnum {
	protected enum State {
		Empty(0),
		Black(1),
		White(2);

		private final int num;

		private MyEnum(int num){
			this.num = num;
		}

		protected int getEnum() {
			return num;
		}
	}
}
