package basic_171122;

public class OverTest {
	public static void main(String[] args) {
		OverGo og = new OverGo();

		System.out.println(og.upMethod());
		System.out.println(og.upMethod(5));
		System.out.println(og.upMethod(5,7));
	}
}

class OverUp {
	int x = 1;
	int y = 2;

	String upMethod() {
		return "하이" + x + y;
	}
}

class OverGo extends OverUp {
	int z = 3;

	@Override
	String upMethod() {

		return "오버라이딩";
	}

	String upMethod(int k) {
		return "오버로딩";
	}

	String upMethod(int k, int z) {
		return "오버로딩 : " + x + y + z + k + this.z;
	}
}
