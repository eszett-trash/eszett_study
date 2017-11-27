package pizzaPrj;

public interface IReg {

	// 로그인 관리
	public boolean Login(String id, String pwd);

	// 관리자인지 확인 (아이디를 DB에서 체크해서 플래그 걸고 관리자면 트루 리턴)
	public boolean isAdmin(String id);

}

interface Ipayment {

}
