package hw;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDateMain {
	public static void main(String[] args) {
		int arrNum = 3;
		PersonArray pa = new PersonArray(arrNum);
		Person[] p = new Person[arrNum];

		p[0] = new Person("이름1", "010-5558-8888", new MyDate(2004, 10, 15));
		p[1] = new Person("이름2", "010-8888-1234", new MyDate(2014, 9, 4));
		p[2] = new Person("이름3", "010-1234-8888", new MyDate(2002, 7, 7));

		pa.setPerson(p);
		System.out.println(pa);
		
		PersonCollection pc = new PersonCollection();
		
		pc.setPerArr(p[0]);
		pc.setPerArr(p[1]);
		pc.setPerArr(p[2]);
		
		for (int i = 0; i < pc.getPerArr().size(); i++) {
			System.out.print(pc.getPerArr().get(i));
		}
	}
}

class MyDate {
	int year;
	int month;
	int day;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return "MyDate || year : " + year + ", month : " + month + ", day : "
				+ day;
	}
}

class Person {
	String name;
	String tel;
	MyDate date;

	public Person(String name, String tel, MyDate date) {
		super();
		this.name = name;
		this.tel = tel;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\nPerson || name : " + name + ", tel : " + tel + ", date : "
				+ date;
	}
	
}

class PersonArray {
	private Person[] person;

	public PersonArray(int num) {
		person = new Person[num];
	}

	public void setPerson(Person[] person) {
		this.person = person;
	}

	public Person[] getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "PersonArray || person : " + Arrays.toString(person);
	}

}

class PersonCollection {
	ArrayList<Person> perArr;

	PersonCollection() {
		perArr = new ArrayList<Person>();
	}

	public void setPerArr(Person p) {
		perArr.add(p);
	}

	public ArrayList<Person> getPerArr() {
		return perArr;
	}
}