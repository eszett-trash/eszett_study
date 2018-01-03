package javaIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIoTest {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		byte[] temp = new byte[4]; // <<4바이트씩 읽어옴

		System.out.println("inSrc = " + Arrays.toString(inSrc));
		System.out.println("outSrc = " + Arrays.toString(outSrc));

		// available() ->읽어올 수 있는 데이터의 byte수를 반환한다.
		try {
			while (input.available() > 0) {
//				input.read(temp);
//				output.write(temp);
				int len = input.read(temp);
				System.out.println("작업중... " + Arrays.toString(temp));
			}
			outSrc = output.toByteArray();
			System.out.println(Arrays.toString(inSrc));
			System.out.println(Arrays.toString(temp));
			System.out.println(Arrays.toString(outSrc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
