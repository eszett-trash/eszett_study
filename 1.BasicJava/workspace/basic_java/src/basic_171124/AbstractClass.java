package basic_171124;

public class AbstractClass {

}

abstract class Unit{

	int x;
	int y;

	abstract void move(int x, int y);
	void stop()
	{
		
	}
}

class Marine extends Unit{

	@Override
	void move(int x, int y) {
	// TODO Auto-generated method stub
	
	}
	
	void stimPack()
	{
		
	}
}

abstract class Tank extends Unit{

	
	void changeMode()
	{
		
	}
}