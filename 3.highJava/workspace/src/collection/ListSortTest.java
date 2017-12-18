package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("apple");
		al.add("pasta");
		al.add("banana");
		al.add("jam");
		al.add("cheese");
		
		Collections.sort(al);
		
		for (String string : al) {
			System.out.println(string);
		}
		
		Collections.shuffle(al);
		System.out.println();
		
		for (String string : al) {
			System.out.println(string);
		}
		
		Collections.sort(al); //오름차준
		System.out.println("정렬 후 : " +al);
		Collections.shuffle(al);
		System.out.println("섞음 : "+al);
		Collections.sort(al, new Desc());
		System.out.println("정렬 후 : " +al);
	}
	
	/**
	 * 정렬과 관련된 인터페이스는 Comparable과 comparator 두가지가 있다.
	 * 
	 * 객체 자체에 정렬기능을 넣을 때는 Comparable을 구현하고
	 * 정렬기준을 별도로 구현하고 싶을때는 Comparator를 구현하여 사용하면 된다.
	 * 
	 * Comparable 인터페이스에서는 compareTo()메서드를 구현
	 * Comparator 인터페이스에서는 compare()메서드를 구현해야 한다.
	 * 
	 * 오름차순을 기준으로 앞의 값이 크면 양수, 같으면 0 작으면 음수 반환
	 * 양수반환시 앞뒷값의 순서가 바뀐다
	 * 
	 * String Wrapper Date File에는
	 */

}
class Desc implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2)*-1;
	}

		
}
