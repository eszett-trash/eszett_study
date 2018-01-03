package javaIo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOStreamTest {

	public static void main(String[] args) {

		try {
			FileOutputStream fOut = new FileOutputStream("D:/D_Other/test.dat");
			//dataOutPutStream은 출력용 데이터를 자료형에 맞게 출력 해 준다.
			DataOutputStream dOut = new DataOutputStream(fOut);
			
			dOut.writeInt(200);
			dOut.writeFloat(142.23f);
			dOut.writeUTF("qwe");
			System.out.println("출력완료");
			dOut.close();
			
			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			System.out.println(din.readInt());
			System.out.println(din.readFloat());
			//System.out.println(din.readBoolean());
			System.out.println(din.readUTF());
			
			din.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
