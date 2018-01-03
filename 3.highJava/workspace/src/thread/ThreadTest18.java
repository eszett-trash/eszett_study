package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 벡터, 해시테이블등 이전부터 존재하던 자료구조들은 내부에 동기화 처리가 되어있다.
 하지만 최근 새로 구성된 것들은 동기화가 되어있지 않기떄문에 동기화를 해서 사용해야한다.
 */
public class ThreadTest18 {
	// 동기화 하지 않은 List
	private static List<Integer> list2 = new ArrayList<>();

	// 동기화 처리를 한 List
	private static List<Integer> list1 = Collections
			.synchronizedList(new ArrayList<Integer>());

	public static void main(String[] args) {

		// 익명클래스로 스레드 구현
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list2.add(i);
			}
			System.out.println("list1 : " + list1.size());
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list1.add(i);
			}
			System.out.println("list2 : " + list2.size());
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list1.add(i);
			}
			System.out.println("list2 : " + list2.size());
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list1.add(i);
			}
			System.out.println("list2 : " + list2.size());
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list1.add(i);
			}
			System.out.println("list2 : " + list2.size());
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				list1.add(i);
			}
			System.out.println("list2 : " + list2.size());
		}).start();
	}
}
