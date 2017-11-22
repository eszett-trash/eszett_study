package awt_game;

public class AwtScript {
	public static void main(String[] args) {
		MobAI mma = new MobAI();
		
	}
}

class CreaetMob {
	// 맵 레벨에 따라서 레벨 자동 생성
	//

	final int MAX_HP = 999;
	final int MAX_MP = 999;

	int race;
	int hp;
	int sp;
	int have_money;
	int exp;
	int level;

	int atk;
	int def;

	SkillList skill; // 종족과 레벨을 판단해서 스킬을 넣어줌
	
	//기본적으로 몹 숫자는 1~3 랜덤.. 몹 생성해줌.
	MobAI[] mobmoveai = new MobAI[(int)(Math.random()*3+1)];
	//몹 위치도 랜덤으로 뿌려줌(구현할것)

}

class CreateMap {
	final int MapX = 3;
	final int MapY = 3;

	int mapLevel;

}

