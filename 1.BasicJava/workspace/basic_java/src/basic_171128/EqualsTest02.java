package basic_171128;

public class EqualsTest02 {
	public static void main(String[] args) {
		Person p1 = new Person(9210272222222L);
		Person p2 = new Person(9210272222222L);

		System.out.println(p1.equals(p2));
		System.out.println(p1);
		System.out.println(p1.hashCode());
	}
}

class Person {
	long id;

	public Person(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj != null && obj instanceof Person) {
			result = id == ((Person) obj).id;
		}
		return result;
	}
}