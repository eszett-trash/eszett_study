package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(254, "가나다", 25, 78, 71));
		list.add(new Student(234, "가ㅇㅇ", 35, 78, 78));
		list.add(new Student(24, "어쩌구", 64, 48, 76));
		list.add(new Student(252, "머시기", 55, 28, 58));
		list.add(new Student(454, "이름머", 65, 28, 48));
		list.add(new Student(284, "하지모", 25, 58, 38));
		list.add(new Student(154, "르겟다", 35, 67, 72));
		list.add(new Student(54, "가나다", 64, 77, 71));
		
		
		for (int i = 0; i < list.size(); i++) {
			int rank = 1;
			int temp = list.get(i).getTotal();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getTotal()>temp) {
					rank++;
				}
			}
			list.get(i).setRank(rank);
		}

		Collections.sort(list, new InscSort());

		for (Student student : list) {
			System.out.println(student);
		}

		System.out.println();
		Collections.sort(list, new DescSort());

		for (Student student : list) {
			System.out.println(student);
		}
	}
}

class DescSort implements Comparator<Student> {

	// 총점으로 정렬(작->큰)
	// 총점이 같으면 학번이 (큰->작)
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getTotal() > o2.getTotal()) {
			return -1;
		} else if (o1.getTotal() == o2.getTotal()) {
			return o2.getId() > o1.getId() ? 1 : -1;
		} else {
			return 0;
		}
	}

}

class InscSort implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId() < o2.getId() ? -1 : 1;
	}

}

class Student {
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;

	public Student(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// TODO 나중에 할 수 잇음 하기
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student || id : " + id + ", name : " + name + ", kor : " + kor
				+ ", eng : " + eng + ", math : " + math + ", total : " + total
				+ ", rank : " + rank;
	}

}