package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 10마리의 말들이 경주를 하는 경마 프로그램 작성하기

 말은 Hourse라는 이름의 클래스로 구성하는데
 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 기능이 있다.
 (Comparable인터페이스 구현)

 경기 구간은 1~50구간으로 되어 있다.

 경기 중 일정한 시간마다 현재 말의 위치를 출력한다.
 예)
 01번말 : --->-----------------------------------
 02번말 : ------>--------------------------------
 03번말 : ---->----------------------------------
 04번말 : -------->------------------------------
 ...
 10번말 : ----->---------------------------------

 경기가 끝나면 등수 순으로 출력한다.
 */
public class RunningHorse {
	public static int tempRank = 0;

	public static void main(String[] args) {
		ArrayList<DisplayHores> ds = new ArrayList<DisplayHores>();
		DisplayHores[] dh = new DisplayHores[10];
		for (int i = 0; i < 10; i++) {
			dh[i] = new DisplayHores(i + "");
			ds.add(dh[i]);
		}
		for (int i = 0; i < 10; i++) {
			dh[i].start();
		}
		for (DisplayHores displayHores : dh) {
			try {
				displayHores.join();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < dh.length; i++) {
			Collections.sort(ds, new Desc());
		}

		for (int i = 0; i < ds.size(); i++) {
			System.out.println(ds.get(i));
		}
	}
}

class DisplayHores extends Thread {
	private String horseName;
	private int pos;
	private int rank = 0;

	public DisplayHores(String horseName) {
		this.horseName = horseName;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	private void print() {

		String str = "";
		str += horseName + "번 마 : ";
		for (int i = 0; i < 50; i++) {
			if (pos == i) {
				str += ">";
			} else {
				str += "-";
			}
		}
		System.out.println(str);
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				pos = i;
				print();
				Thread.sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		RunningHorse.tempRank += 1;
		setRank(RunningHorse.tempRank);
	}

	@Override
	public String toString() {
		return horseName + "번 마 :  " + rank + "위";
	}
}

class Desc implements Comparator<DisplayHores> {

	@Override
	public int compare(DisplayHores o1, DisplayHores o2) {
		return o1.getRank() > o2.getRank() ? 1 : -1;
	}
}
