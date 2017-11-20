package basic_17120;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class DrawShape extends Frame {
	public static void main(String[] args) {

		DrawShape ds = new DrawShape("도형그리기 타이틀");
		
	
	}

	public DrawShape() {
		super("도형 그리기");
		setSize(800, 600);
		setVisible(true);
		setBackground(Color.pink);
	}

	DrawShape(String title) {
		super(title);
		setSize(800, 600);
		setVisible(true);
		setBackground(Color.cyan);
	}
	
	@Override//상속받을때만 가능
	public void paint(Graphics g) {

//		Point p = new Point(100,100);
//		Circle c2 = new Circle(p,100);
//		
//		g.drawOval(c2.c.x, c2.c.y, 300, 300);
		
		//4.삼각형 객체를 만든다.
		//100,100 / 200,200 / 200,100
		
//		Point p = new Point(100,100);
		Point[] pt = new Point[3];
		pt[0] = new Point(100,100);
		pt[1]= new Point(200,200);
		pt[2]= new Point(200,100);
		//Triangle tri = new Triangle(pt[0], pt[1], pt[2]);
		Triangle tri = new Triangle(pt);
		
		
		//5.//g.drawLine()
		g.drawLine(tri.pt[0].x,tri.pt[0].y,tri.pt[1].x,tri.pt[1].y);
		g.drawLine(tri.pt[1].x,tri.pt[1].y,tri.pt[2].x,tri.pt[2].y);
		g.drawLine(tri.pt[2].x,tri.pt[2].y,tri.pt[0].x,tri.pt[0].y);

		
	}
}

class Point {
	int x;
	int y;

	Point() {//매개변수가 들어오지 않으면 0,0으로 초기화
		this.x = 0;
		this.y = 0;
	}

	Point(int x, int y) { //매개변수가 들어오면 x,y로 초기화
		this.x = x;
		this.y = y;
	}
}

class Circle{
	
	Point c;
	int r;
	
	Circle()
	{
		//0,0 에 반지름 100짜리 호출()
		this.c = new Point();
		this.r = 100;
		
	}

	Circle(Point point, int r)
	{
		this.c = point;
		this.r = r;
	}
	
}

class Triangle{
	//점 세개를 담을 수 있는 변수를 만드세요.
	Point[] pt = new Point[3];
	//매개변수가 하나인 생성자를 만들어
	//위에서 만든 변수에 저장해주세요
	Triangle() {}
	Triangle(Point[] pt)
	{
		for(int i = 0; i<pt.length ; i++)
		{
			this.pt[i] = pt[i];
		}
	}
	Triangle(Point pt1, Point pt2, Point pt3)
	{
		this.pt[0] = pt1;
		this.pt[1] = pt2;
		this.pt[2] = pt3;
	}

	//매개변수가 세개인 생성자를 만들어 위에서 만든 변수에 저장해주세요.
}















