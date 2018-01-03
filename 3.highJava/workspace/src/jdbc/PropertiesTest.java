package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	
	//외부 properties확장자 파일을 읽어와 객체로 처리하기
	public static void main(String[] args) {
		//정보저장을 위한 객체 생성
		Properties prop = new Properties();
		// 읽어 올 파일명을 이용한 한File 객체 생성
		File file = new File("res/db.properties");
		
		try {
			//파일읽기
			FileInputStream fIs = new FileInputStream(file);
			//load()로 파일읽기
			prop.load(fIs); //key와 value로 분리
			//읽어온 정보 출력해보기
			//key값만 읽어오기 -- > 읽어온 정보를 enumeration객체로 변환
			@SuppressWarnings("unchecked")
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			//key값 개수만큼 반복해서 값 출력
			while(keys.hasMoreElements()) // it.hasnext()와 비슷
			{
				String key = keys.nextElement(); // key값 1개를 가져오기
				String value = prop.getProperty(key);
				System.out.println(key +"\t\t"+ value);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
