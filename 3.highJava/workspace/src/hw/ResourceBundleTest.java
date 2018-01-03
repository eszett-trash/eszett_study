package hw;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class ResourceBundleTest {
	public static void main(String[] args) {
		//파일을 지정할떄는 파일명ㅁ만 지정하고 확장자는 하지 않음
		//이유 :항상동일한 확장자
		
		ResourceBundle rb = ResourceBundle.getBundle("db");
		//key값만 가져오기
		Enumeration<String> keys = rb.getKeys();
		
		while (keys.hasMoreElements()) {
			String string = (String) keys.nextElement();
			System.out.println(string);
		}
	}
}
