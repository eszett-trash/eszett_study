package mvcTest.member;

public class MemberVO {
/*
  VO ->데이터를 저장하는 역할만 하는 클래스
   	   ->DB테이블에서 1개의 레코드를 저장할 클래스
   	   
  DAO ->SQL문을 DB서버에 보내서 결과를 얻오으는 역할을 하는 클래스
  
  Service -> 중간관리자 역할을 하는 클래스 DAO를 호출해 일을 처리한 후 컨트롤러에게 전달한다
  Controller -> 비지니스 로직이 시작되는 곳으로, 일을 만들어서 Service에게 보일을 시키고 서비스가 보내온
  					처리결과를 화며능에 반영
 */
	
	private String mem_id;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public static void main(String[] args) {
	}
}
