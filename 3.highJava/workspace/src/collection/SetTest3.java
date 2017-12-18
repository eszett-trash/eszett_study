package collection;

import java.util.HashSet;

public class SetTest3 {
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<Person>();

		hs.add(new Person(1, "이름1"));
		hs.add(new Person(1, "이름1"));
		hs.add(new Person(1, "이름1"));
		hs.add(new Person(1, "이름1"));
		System.out.println(new Person(1, "이름1").equals(new Person(1, "이름1")));
		System.out.println(new Person(1, "이름1").equals(new Person(2, "이름1")));
	}

}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonSortedSet<String> ss1 =  || id : " + id + ", name : "
				+ name + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Person that = (Person) obj;
		if (this.name == null && that.name != null) {
			return false;
		}
		if (this.id == that.id && this.name.equals(that.name)) {
			return true;
		}
		return false;
	}
	/*
	 	-equals메서드는 두 객체의 내용이 같은지 , 즉 동등성(equility)을 비교하는 연산자
	 	-hashCode메서드는 두 객체가 같은 객체인지, 즉 동일성(identity)을 비교하는 연산자
	 	-hashSet, hashMap, hashTable과 같은 컬렉션 객체들을 사용 할 경우
	 	 객체의 의미상의 동등성 비교를 위해 hashCode()를 호출한다.
	 	 그러므로 객체가 같은지여부를 결정하려면 equals()메서드뿐만 아니라 hashCode()도 재정의해야한다.
	 	 
	 	 -hashCode()와 equals()에 관한 규칙
	 	 	1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
	 	 	2. 두 객체가 같으면 equals()메서드를 호출햇을 때 true를 반환해야 한다.
	 	 		즉 a,b가 같으면 a.equals(b)와 b.equals(a) 둘 다 true를 반환해야 한다.
	 	 	3. 두 객체의 hashCode가 같다고 해서 반드시 같은것은 아니다.
	 	 	4. equals()메서드를 override하면 반드시 hashCod()도 override 해야한다.
	 	 	5. hasgCode(0에서는 기본적으로 Heap에 있는 각 객체에 대한 메모리주소의 매핑 정보를 기반으로
	 	 	   한 정수값을 반환한다. 그래서 class에서 hashCode()메서드를 override하지 않으면 절대로 그 유형
	 	 	   의 두 객체가 같은것으로 간주될 수 없다.
 	 	    6. equals()메서드는 기본적으로 == 연산자를 사용하여 객체를 비교한다.
 	 	       따라서 equals()를 override핮 ㅣ않으면 절대로 그  유형의 두 객체가 같은 것으로 간주될 수 없다.
 	 	       
 	 	       참고 : hashCode()메서드에서 사용하는 '해싱 알고리즘'에서 서로 다른 객체들에 대해 같은 hashcode
 	 	       값을 만들어 낼 수 있기 때문에 객체가 같지 않더라도 hashcode는 같을 수 잇다.
	  */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + id;
		return result;
	}
}