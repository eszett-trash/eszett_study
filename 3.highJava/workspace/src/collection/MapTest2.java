package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 예제 ) 5명의 이름과 전화번호를 입력하여 Map에 저장한 후 이름을 입력하면 해당 사람의 전화번호가 출력되는 프로그램을 작성하시오
 
 */
public class MapTest2 {
	public static void main(String[] args) {
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		HashMap<String, String> map4 = new HashMap<String, String>();
		HashMap<String, String> map5 = new HashMap<String, String>();
		
		map1.put("name","이름 1");
		map1.put("tel","전번 1");
		map2.put("name","이름 2");
		map2.put("tel","전번 2");
		map3.put("name","이름 3");
		map3.put("tel","전번 3");
		map4.put("name","이름 4");
		map4.put("tel","전번 4");
		map5.put("name","이름 5");
		map5.put("tel","전번 5");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);

		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).containsValue("이름 1")) {
				System.out.println(list.get(i).get("tel"));
			}
		}
	}
}
