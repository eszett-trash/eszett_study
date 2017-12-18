package collection;

import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		/*
		 Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
		 Map은 모든 형태의 객체를key와 value값으로 넣을 수 있지만
		 Properties는 key와 value값으로 String만 사용 할 수 있다.
		 
		  Map은 데이터를 입출력 할 때 get(), put()메서드를 사용하지만
		  Properties는 setProperty(), getProperty()메서드를 사용한다. 
		 */
		
		Properties prop = new Properties();
		prop.setProperty("name","홍길동");
		prop.setProperty("tel","010-8875-7785");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println(name + "    " + tel);
	}
}
