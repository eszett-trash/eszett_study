package collection;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		// Vector
		// 배열처럼 사용하는 컬렉션중 하나.
		// 기본적으로 리스트와 동일
		// thread에서 동기화가 되도록 구현이 되어있기때문에 안전하지 못하다.
		// multi thread사용시 container에서 lock를 직접 걸어줘야한다.
		// 항상 동기화가 되어있기 때문에 system resource를 더 많이 먹는다고 함

		Vector<Object> vec = new Vector<>();
		System.out.println("처음 크기 :" + vec.size());

		// add의 return type은 boolean
		vec.add("게에엑");
		vec.add(1); // compiler를 이용하여 auto boxing
		vec.add(new Integer(123)); // wrapper class를 통한 객체생성
		vec.add(2, "구웨에엑");
		vec.add('a'); // compiler를 이용하여 auto boxing
		vec.add(new Character('b')); // wrapper class를 통한 객체생성
		System.out.println("다음 크기 :" + vec.size());
		System.out.println(vec);
		// add의 return type은 void
		vec.addElement(vec.toString());
		// addElement는 데이터를 추가 할 때 동기화 작업을 수행한다.
		System.out.println("마지막 크기 :" + vec.size());

		// set의 return type은 기존 데이터의 객체
		System.out.println(vec.set(2, "구웨에엑 -> 게에에에에엑"));
		// setElementAt의 return type은 void
		System.out.println(vec);

		vec.remove(2); // 삭제한 데이터가 반환값이 된다.
		// 인덱스 삭제도 가능하고 객체 삭제도 가능하기 때문에 정수형이나 char형을 넣으면 그 인덱스에 있는 객체가 지워진다.
		// 동일한데이터가 있으면 앞에있는 데이터부터 삭제됨.

		// ========================================================
		// Generic type이라는 것은 객체를 선언할 때 <> 안에 그 collection이 사용 할 데이터 타입을 정해주는 것
		// 그 데이터타입 이외의 다른 데이터를 저장 할 수 없다.
		// generic으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		// 다른종류의 데이터를 추가 할 수 없다.

		Vector<String> vector = new Vector<String>();

		vector.add("구웨에에에엑");

		Vector<Vector> vv = new Vector<Vector>();

		vv.add(vec);
		vv.add(vector);

		System.out.println(vv);
		vector.clear(); // 데이터 전부 삭제
		System.out.println(vv + "\n벡터의 사이즈는 : " + vec.size());

		// v1.removeAll(collection 객체) => 'Collection객체'가 가지고 있는 데이터중 v1과 공통인
		// 데이터를 모두 삭제한다.

		Vector<String> v1 = new Vector<String>();

		v1.add("A");
		v1.add("B");
		v1.add("C");
		v1.add("D");
		v1.add("E");

		Vector<String> v2 = new Vector<String>();
		v2.add("B");
		v2.add("C");
		v2.add("F");

		System.out.println(v1);
		System.out.println(v2);

		v1.removeAll(v2);

		System.out.println(v1);

		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + 1 + "번째 자료 : " + v2.get(i));
		}
		
		//for each문
		for (String s : v2) {
			System.out.println(s);
		}
		for (Object obj : vec) {
			System.out.println(obj);
		}
	}
}
