package collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList는 기본적인 사용법이 Vector와 동일
		
		ArrayList<Object>list1 = new ArrayList<>();
		ArrayList<Integer>list2 = new ArrayList<>();
		
		
		list1.add("aa");
		list1.add("bb");
		list1.add(111);
		list1.add('k');
		list1.add(true);

		System.out.println(list1);
		//contains (비교객체); 리스트에 비교객체가 있는 지 확인
		System.out.println(list1.contains("aa"));
	
		//indexOf(비교객체); 비교 객체가 없으면 -1리턴
		System.out.println(list2.indexOf(1));
		
		//toArray() : 리스트 안의 데이터들을 배열로 변환하여 반환한다. 기본적으로는 Object형 배열로 반환한다.
		
		Object obj[] = list1.toArray();
		
		System.out.println(obj.length);
		for (Object o : obj) {
			System.out.println(o);
		}
		System.out.println(Arrays.toString(obj));
	}
}
