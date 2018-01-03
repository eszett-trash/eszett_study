package javaIo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOStreamTest {
	public static void main(String[] args) {
		// member의 인스턴스 생성
		Member mem1 = new Member("ㄱㄴㄷ", 10, "asa");
		Member mem2 = new Member("ㄹㅁㅂ", 11, "asb");
		Member mem3 = new Member("ㅅㅇㅈ", 12, "asc");
		Member mem4 = new Member("ㅊㅍㅎ", 13, "asd");

		// 객체를 파일에 저장하기
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							"D:/D_Other/member.obj")));

			// 쓰기
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);

			oos.close();
			System.out.println("Success Writing....");

			// =====================================
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(
							"D:/D_Other/member.obj")));
			
			Object obj = null;
			try {
				while ((obj=ois.readObject())!= null) {
					//읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
					Member mem = (Member) obj;
					System.out.println("이름 : " + mem.getName());
					System.out.println("나이 : " + mem.getAge());
					System.out.println("주소 : " + mem.getAddr());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

// 직렬화하여 저장 할 수 있는 클래스 정의
class Member implements Serializable {

	// transient : 직렬화 되지 않을 멤버변수에 지정한다.
	// 직렬화 하지 않는 멤버변수는 초기값으로 저장된다.
	private String name;
	private transient int age;
	private transient String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6920632541952778543L;

}