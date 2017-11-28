package basic_171128;

public class ShallowDeepCopy {
	public static void main(String[] args) {
		Circle c = new Circle(new Point(3, 3), 10);
		Circle cClone = c.deepCopy();
		
		System.out.println("===============이전=================");
		System.out.println(c);
		System.out.println(cClone);
		
		c.r = 100;
		c.p.x = 50;
		
		System.out.println("===============이후=================");
		System.out.println(c);
		System.out.println(cClone);
	}
}

class Circle implements Cloneable{
	Point p;
	int r;
	
	public Circle(Point p, int r) {
		this.p = p;
		this.r = r;
		
	}

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}
	
	//얕은복사
	public Circle shallowCopy()
	{
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle) obj;
	}
	//깊은복사
	//
	public Circle deepCopy() {
		
		//얕은 복사를 함
		Circle obj = null;
		try {
			obj = (Circle) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Point point = new Point(p.x,p.y);
		obj.p = point;		
		return obj;
	}
}