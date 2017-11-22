package basic_171122;

public class SuperClass01 {
	public static void main(String[] args) {
		Child cd = new Child();
		
		System.out.println(cd.getAdd());
	}
}

class Parent {
	int x = 10;
	int y = 20;

	int getAdd() {
		return x + y;
	}

}

class Child extends Parent {

	int x = 30;
	int z = 40;
	
	@Override
	int getAdd() {
		// TODO Auto-generated method stub
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
		return super.getAdd();
	}
}