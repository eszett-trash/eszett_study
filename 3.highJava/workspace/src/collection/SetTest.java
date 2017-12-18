package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * List와 Set의 차이점
 * 
 * 1. List
 * 		-데이터에 순서가 있다( 입력 한 순서로 저장되어있다)
 * 		-중복되는 데이터를 저장 할 수 있다.
 * 
 * 2. Set
 * 		-데이터의 순서가 없다
 * 		-중복되는 데이터를 저장 할 수 없다.
 * 		-자료의 수정이 되지 않기 때문에 해당 자료를 삭제 후 추가 해 주어야 한다.
 * 		-Set은 데이터의 순서가 없기 때문에 List처럼 인덱스로 데이터를 하나씩 불러올 수 없다.
 * 		 그래서 데이터를 하나씩 얻기 위해서는 Iterator객체로 변환해야한다.
 * */
public class SetTest {
	public static void main(String[] args) {
		HashSet<Object> hs1 = new HashSet<Object>();
		System.out.println(hs1.add("23"));
		System.out.println(hs1.add("ㅈㄷ"));
		System.out.println(hs1.add("24"));
		System.out.println(hs1.add("2324"));
		System.out.println(hs1.add("ㅈㄷㅂ"));
		System.out.println(hs1.add("ㅈㄷㅂ"));
		System.out.println(hs1.add("232"));
		System.out.println(hs1.add("363"));
		System.out.println(hs1.add("ㅁㅁ"));
		System.out.println(hs1.add("ㅂㅂ"));
		System.out.println(hs1);
		hs1.remove("24");
		System.out.println(hs1);
		// Set데이터를 Iterator로 변환하기
		Iterator<Object> it = hs1.iterator();
		/*
		 * Iterator의 메서드 1.hasNext(); => 다음번에 자료가 있는지 검사 2. next(); => 자료를 가리키는
		 * 포인터를 다음 자료 위치로 이동시키고 이동한 위치의 자료를 읽어 반환한다.
		 */
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		HashSet<Integer> numSet = new HashSet<Integer>();
		while(numSet.size()<3)
		{
			numSet.add((new Random().nextInt(100)));
		}
		System.out.println(numSet);
		
		/*
		 	TreeSet에저장된 자료중 특정한 자료보다 작은 자료를 찾아서
		 	SortedSet으로 반환하는 메서드가 잇다. -> hdadSet(기준값) 메서드
		 	기준값의 포함여부는 기준 값 다음 true,false를 지정하여 정할 수 잇다. (default : false)
		 */
		
	TreeSet<String> ts = new TreeSet<String>();
	
	for (char i = 'A'; i <='Z'; i++) {
		ts.add(String.valueOf(i));
	}
	System.out.println(ts);
	SortedSet<String> ss1 = ts.headSet("D");
	System.out.println(ss1);
	// tailset(기분값보다 ㅋㄴ 자료룰 앚아 세팅)
	}
}
