package javaIo;

import java.io.FileOutputStream;

public class FileStreamTest02 {
	public static void main(String[] args) {
		FileOutputStream fOut = null;
		
		try {
			fOut = new FileOutputStream("D:\\eszett_study\\3.highJava\\workspace\\out.txt");
		
			for (int i = 0; i < 10; i++) {
				fOut.write(i);
			}
			System.out.println("끝");
			fOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
