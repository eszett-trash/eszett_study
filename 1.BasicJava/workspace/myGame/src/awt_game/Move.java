package awt_game;

public class Move {
	final int MAX_XPOS = 2;
	final int MAX_YPOS = 2;

	final int MIN_XPOS = 0;
	final int MIN_YPOS = 0;

	int xPos;
	int yPos;

	public Move() {
		this.xPos = 1;
		this.yPos = 1;
	}

	public Move(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	int moveRimitX(int xPos) {

		// xpos 맵 안넘어가게
		if (xPos > MAX_XPOS) {
			this.xPos = MAX_XPOS;
		} else if (xPos < MIN_XPOS) {
			this.xPos = MIN_XPOS;
		} else {
			this.xPos = xPos;
		}
		return this.xPos;
	}

	int moveRimitY(int yPos) {
		// ypos 맵 안넘어가게
		if (yPos > MAX_YPOS) {
			yPos = MAX_YPOS;
		} else if (yPos < MIN_YPOS) {
			yPos = MIN_YPOS;
		}
		return this.yPos = yPos;
	}

	int moveLeft() 	{return moveRimitX(--xPos);}
	int moveRight() {return moveRimitX(++xPos);}
	int moveDown() 	{return moveRimitY(--yPos);}
	int moveUp() 	{return moveRimitY(++yPos);}
	
	void print() {
		System.out.println("xPos= " + xPos);
		System.out.println("yPos= " + yPos);
		System.out.println();
	}
}
