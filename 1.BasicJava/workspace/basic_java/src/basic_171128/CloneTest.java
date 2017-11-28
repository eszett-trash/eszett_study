package basic_171128;

public class CloneTest {
	public static void main(String[] args) {
		CloneEx cs = new CloneEx(3, 3);
		Cloneable cxCloneable = (Cloneable) cs.clone();
		System.out.println("============이전===========");
		System.out.println(cs);
		System.out.println(cxCloneable);

		cs.x = 10;
		
		System.out.println("============이후===========");
		System.out.println(cs);
		System.out.println(cxCloneable);
		
	}
}

class CloneEx implements Cloneable {

	int x;
	int y;

	CloneEx(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

}