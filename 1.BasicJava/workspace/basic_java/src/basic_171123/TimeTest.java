package basic_171123;

public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time();

//		t.setHour(83);
//		t.setMinute(150);
//		t.setSecond(10000);
		t.setSecond(43199);
		System.out.println(t.toString());
	}
}

class Time {

	private int hour;
	private int minute;
	private int second;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour % 24;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute > 59) {
			setHour(this.hour += minute / 60);
		}
		this.minute = minute % 60;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second > 59) {
			setMinute(this.minute += second / 60);
		}
		this.second = second % 60;

	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second="
				+ second + "]";
	}

}
