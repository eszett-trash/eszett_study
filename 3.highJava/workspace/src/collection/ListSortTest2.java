package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {
	public static void main(String[] args) {
		ArrayList<Member> mem = new ArrayList<Member>();
		SortNumDesc sc = new SortNumDesc();

		mem.add(new Member(154, "가나다", "010-888-7875"));
		mem.add(new Member(65, "몰러", "010-888-7875"));
		mem.add(new Member(20, "머더라", "010-888-7875"));
		mem.add(new Member(24, "박최머", "010-888-7875"));
		mem.add(new Member(45, "이박최", "010-888-7875"));
		mem.add(new Member(101, "김이박", "010-888-7875"));

		System.out.println("정렬 전");
		for (Member member : mem) {
			System.out.println(member);
		}
		System.out.println("끝");
		// 외부정렬을 가져옴
		Collections.sort(mem, new SortNumDesc());

		for (Member member : mem) {
			System.out.println(member);
		}
	}

}

//내부객체의 정렬
class Member implements Comparable<Member> {
	private int mem_id;
	private String name;
	private String cp;

	public Member(int mem_id, String name, String cp) {
		this.mem_id = mem_id;
		this.name = name;
		this.cp = cp;
	}

	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public int compareTo(Member o) {
		// 자신과 자기 다음에 잇는 데이터를 비교하는 것. o는 다음에 올 데이터.
		return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "Member || mem_id : " + mem_id + ", name : " + name + ", cp : "
				+ cp;
	}

}

// 정렬기준의 외부선언을 위해서는 comparator를 구현한다.
// 다른곳에 잇는 자료의 정렬을 가능하게 함.
class SortNumDesc implements Comparator<Member> {

	@Override
	public String toString() {
		return "SortNumDesc ";
	}

	@Override
	public int compare(Member o1, Member o2) {
		//return o1.getMem_id() > o2.getMem_id() ? 1 : -1;

		//Wrapper클래스를 이용하는 방법
		
		//return new Integer(o1.getMem_id()).compareTo(new Integer(o2.getMem_id()))*-1;
		//위와 동일한 코드
		Integer n1 = new Integer(o1.getMem_id());
		Integer n2 = new Integer(o2.getMem_id());
		return n1.compareTo(n2);
	}
	
}