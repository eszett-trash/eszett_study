package collection;

import java.util.ArrayList;
import java.util.HashSet;

public class SetTest2 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		//collection내의 데이터들은 서로 쉽게 바꿀 수 있다.
		ArrayList<String> arr = new ArrayList<String>(hs);
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		arr.add("22");
		//이케하면 중복제거되네
		HashSet<String> hs2 = new HashSet<String>(arr);
		System.out.println(hs2);
	}
}
