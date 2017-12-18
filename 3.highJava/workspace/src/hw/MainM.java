package hw;

import java.util.Calendar;
import java.util.Scanner;

class Clock {

	public String getTime() {

		Calendar a = Calendar.getInstance();

		return a.get(Calendar.HOUR) + "시 " + a.get(Calendar.MINUTE) + "분 "
				+ a.get(Calendar.SECOND) + "초";
	}
}

class AlarmClock extends Clock {

	int hour;
	int minute;
	int second;

	public void setAlarm(String time) {
		String temp[] = time.split(":");
		hour= Integer.parseInt(temp[0]);
		minute= Integer.parseInt(temp[1]);
		second= Integer.parseInt(temp[2]);
	}

	@Override
	public String getTime() {
		
		return "현재" + super.getTime() +"\n알람" + hour+"시 "+minute +"분 "+second+"초";
	}

}

public class MainM {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Clock c = new Clock();
		System.out.println(c.getTime());
		AlarmClock a = new AlarmClock();
		System.out.println("알람시간을 찍어주세요 (:로 구분)");
		a.setAlarm(s.next());
		
		System.out.println(a.getTime());
	}
}