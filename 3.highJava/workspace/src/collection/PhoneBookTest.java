package collection;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
	// key는 이름으로 value는 phone클래스의 인스턴스로 한다.
	public static void main(String[] args) {
		HashMap<String, Phone> pn = new HashMap<String, Phone>();
		Scanner s = new Scanner(System.in);
		while (true) {
			String name;
			String ph;
			String addr;
			System.out.println("전화번호관리프로그램\n");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체출력");
			System.out.println("0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("새롭게 등록할 전화번호 정보를 입력 하세요");
				System.out.print("이름 >> ");
				name = s.next();
				System.out.print("전화번호 >> ");
				ph = s.next();
				System.out.print("주소 >> ");
				addr = s.next();
				if (!pn.isEmpty()) {
					if (name.equals(pn.get(name).getName())) {
						System.out.println("중복된 이름이 있습니다.");
						break;
					}
				}
				pn.put(name, new Phone(name, addr, ph));
				break;
			case 2:
				if (pn.isEmpty()) {
					System.out.println("전화번호부가 비었습니다.");
					break;
				}
				System.out.println("수정할 이름을 입력 해 주세요");
				name = s.next();
				try {
					if (name.equals(pn.get(name).getName())) {
						System.out.print("전화번호 >> ");
						ph = s.next();
						System.out.print("주소 >> ");
						addr = s.next();
						pn.put(name, new Phone(name, addr, ph));
						System.out.println("수정하였습니다.");
					}
				} catch (Exception e) {
					System.out.println("없는 유저입니다..");
				}
				break;
			case 3:
				if (pn.isEmpty()) {
					System.out.println("전화번호부가 비었습니다.");
					break;
				}
				System.out.println("삭제할 이름을 입력 해 주세요");
				name = s.next();
				try {
					if (name.equals(pn.get(name).getName())) {
						pn.remove(name);
						System.out.println("삭제하였습니다.");
					}
				} catch (Exception e) {
					System.out.println("없는 유저입니다");
				}
				break;
			case 4:
				if (pn.isEmpty()) {
					System.out.println("전화번호부가 비었습니다.");
					break;
				}
				System.out.println("조회할이름을 입력 해 주세요");
				name = s.next();
				try {
					if (name.equals(pn.get(name).getName())) {
						System.out.println(pn.get(name));
					}
				} catch (Exception e) {
					System.out.println(" 없는 유저입니다..");
				}
				break;
			case 5:
				if (pn.isEmpty()) {
					System.out.println("전화번호부가 비었습니다.");
					break;
				}
				System.out.println("번호\t\t이름\t\t전화번호\t\t\t주소\t\t\t");
				int i = 1;
				for (String string : pn.keySet()) {
					System.out.println(i++ + "\t\t" + pn.get(string).getName()
							+ "\t\t" + pn.get(string).getPh() + "\t\t"
							+ pn.get(string).getAddr());
				}
				break;
			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}

class Phone {
	private String name;
	private String addr;
	private String ph;

	public Phone(String name, String addr, String ph) {
		this.name = name;
		this.addr = addr;
		this.ph = ph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Override
	public String toString() {
		return "Phone || name : " + name + ", addr : " + addr + ", ph : " + ph;
	}

}