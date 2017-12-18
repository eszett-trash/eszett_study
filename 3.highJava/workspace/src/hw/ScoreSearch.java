package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ScoreVo {
	private String name;
	private int korean;
	private int english;
	private int math;

	public ScoreVo(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "성적 : 이름:" + name + ", 국어:" + korean + ", 영어:"
				+ english + ", 수학:" + math + "\n";
	}

}

public class ScoreSearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<ScoreVo> temp = new ArrayList<>();
		while (true) {
			System.out.println("===========================");
			System.out.println("성적입력 조회 프로그램");
			System.out.println("===========================");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 조회");
			System.out.println("3. 종료");
			System.out.println("===========================");
			System.out.print(">>메뉴 선택");
			switch (s.next()) {
			case "1":
				
				System.out.println("이름, 국어, 영어,수학점수를 입력 해 주세요");
				temp.add(new ScoreVo(s.next(), s.nextInt(), s.nextInt(), s.nextInt()));
				break;
			case "2":
				System.out.println(temp);
				break;
			case "3":
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}
	
}
