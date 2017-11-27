package basic_171127;

public class Interface01 {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		System.out.println(f instanceof Unit);
	}
}

class Unit {
	int currentHp;
	int x;
	int y;

}
class Fighter extends Unit implements Fightable
{

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
			
	}
	
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(Unit u);
}

interface Fightable extends Movable,Attackable
{
	
}