package javaIo;

import java.io.File;
import java.io.FileInputStream;

public class FileStreamTest {
	public static void main(String[] args) {
		FileInputStream fin = null;

		try {
			// 파일과 여ㅛㄴ결된 입력 스트림 객체를 생성한다.

			// 방법 1
//			fin = new FileInputStream("D:\\eszett_study\\3.highJava\\workspace\\test.txt");
			//방법 2 (파일 정보를 File객체로 지정)
			File file = new File("D:\\eszett_study\\3.highJava\\workspace\\test.txt");
			fin = new FileInputStream(file);
			
			int c;
			while ((c = fin.read()) != -1) {
				System.out.print((char) c);
			}
			fin.close();
		} catch (Exception e) {
			System.out.println("입출력 오류입니다");
		}
	}
}
