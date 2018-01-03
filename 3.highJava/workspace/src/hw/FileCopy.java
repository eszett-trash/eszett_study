package hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {

		try {
			File readFile = new File("D:\\D_Other\\a.jpg");

			FileInputStream fis = new FileInputStream(readFile);
			FileOutputStream fos = new FileOutputStream(new File(
					"D:\\D_Other\\prac\\a_copy.jpg"));

			byte[] temp = new byte[(int) readFile.length()];

			while (fis.read(temp) != -1) {	fos.write(temp);}

			fis.close();
			fos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("끝");
	}
}
