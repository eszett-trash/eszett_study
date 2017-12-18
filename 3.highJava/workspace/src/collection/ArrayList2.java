package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayList2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(s.next());
		}
		s.close();

		// //substring나 contain, startWith을 사용하는 방법두 잇음
		// for (int i = 0; i < list.size(); i++) {
		// if (list.get(i).charAt(0)== '김') {
		// System.out.println(list.get(i));
		// }
		// }
		// }
		String temp = list.get(0);
		int k = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > temp.length()) {
				temp = list.get(i);
				k = list.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명 " + temp);
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() == k) {
				System.out.println(list.get(i));
			}
		}
	}
}
