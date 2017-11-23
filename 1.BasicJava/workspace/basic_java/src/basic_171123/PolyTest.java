package basic_171123;

public class PolyTest {
	public static void main(String[] args) {
		
		SmnartTv st = new SmnartTv();
		SmnartTv[] starr = new SmnartTv[5];
		starr[0] = new SmnartTv();
		starr[1] = new SmnartTv();
		starr[2] = new SmnartTv();
		
		AfreecaTv at = new AfreecaTv();
		AfreecaTv[] atarr = new AfreecaTv[5];
		
		
		//부모타입의 형태로 자손타입의 인스턴스를 참조할 수 있는 것
		Tv[] tvarr = new Tv[6];
		tvarr[0] = new SmnartTv();
		tvarr[1] = new SmnartTv();
		tvarr[2] = new SmnartTv();
		tvarr[3] = new AfreecaTv();
		tvarr[4] = new AfreecaTv();
	}
}

class Tv
{
	boolean power;
	int channel;
	void power()
	{	
		power = !power;
	}
	
	void channelUp()
	{
		channel++;
	}
}


class SmnartTv extends Tv
{
	String interNet;
		
	
	void interNet()
	{
		
	}
}

class AfreecaTv extends Tv
{
	int StarBalloon;
	
	void giveBalloon()
	{
		
	}
}