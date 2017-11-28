package basic_171128;

public class ArrayCopy {
	public static void main(String[] args) {
		Point[] arr = {new Point(1, 1),new Point(2, 2),new Point(3, 3)};
		Point[] arrClone = arr.clone();
		
		
		
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}