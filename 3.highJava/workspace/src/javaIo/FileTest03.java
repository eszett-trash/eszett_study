package javaIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class FileTest03 {
	// 문자기반스트림/바이트기반 스트림
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		int data;

		// 더이상 읽어올자료가없으면 -1을 반환함
		while ((data = input.read()) != -1) {
			// 반복문 내부에서는 읽어온 자료를 처리하는 작업을 수행한다.
			output.write(data);
		}
		// 출력된 스트림값들을 배열로 변환해서 반환하기
		outSrc = output.toByteArray();
		
		System.out.println("inSrc = "+Arrays.toString(inSrc));
		System.out.println("outSrc = "+Arrays.toString(outSrc));
	}
}
