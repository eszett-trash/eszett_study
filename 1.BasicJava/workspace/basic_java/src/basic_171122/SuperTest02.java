package basic_171122;

public class SuperTest02 {
	public static void main(String[] args) {
		
		int flag = 0;
		
		flag |= 1024;
		
		System.out.println(Integer.toBinaryString(flag));
		
//		Point3D p3 = new Point3D(100,100,100);
	}
}

class Point {
	int x = 10;
	int y = 20;

	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {

	int z;
	
	Point3D() {//값이 없는 Point는 상속받지 않ㄹ겠다는 선언
		super(0, 0);
	}
	Point3D(int x, int y, int z)
	{
		super(x, y);
		this.z = z;
	}

}