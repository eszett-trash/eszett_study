package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map ==> key값과 value값을 한 쌍으로 관리하는 객체
		 * 		  ==> key값은 중복을 허용하지 않고 순서가 없다(set의 특징) 
		 *       ==> value값은 중복을 허용한다.
		 */

		HashMap<String, String> map = new HashMap<String, String>();
		// 자료추가 --> (key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");

		System.out.println("map자료 : " + map);
		
		//자료수정 --> 데이터를 저장 할 때 key값이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr","서울");
		System.out.println("map자료 : " + map);
		
		//자료삭제 --> remove(key값)
//		map.remove("addr");
//		System.out.println("map자료 : " + map);
		
		//자료읽기 --> get(key값)
		//			   --> 'key값'의 짝이 되는 'value'값을 읽어온다
		System.out.println(map.get("name"));
		
		//key값이 있는지 여부 --> containsKey(key값)
		System.out.println(map.containsKey("name"));
		System.out.println(map.containsKey("score"));
		
		//모든 key값을 읽어와 자료를 처리하는 방법
		//방법 1 --> keySet() 메서드 이용하기
		//			--> 맵의 key값만 읽어와 set형으로 반환한다.
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("----------------------------------------------------------------");
	
		//방법2 : foreach문 사용 (iterator생성하지 않음)
		for (String string : map.keySet()) {
			System.out.println(string+" : "+map.get(string));
		}
		System.out.println("----------------------------------------------------------------");
		
		//방법3 --> value값만 읽어오기
		//				 values()메서드를 사용한다.
		for (String string : map.values()) {
			System.out.println(string);
		}
		System.out.println("----------------------------------------------------------------");
		//방법 4--> map에 있는 Entry라는 내부 class를 사용함
		//				이 entry클래스의 key와 value라는 멤버변수를 사용
		//				map에서는 이 entry객체를 set형식으로 저장하여 관리한다.
		
		//				이 entry객체 전체를 가져와 처리한다
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIterator = mapSet.iterator();
		
		while (entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next();
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
		}
	}
}





































