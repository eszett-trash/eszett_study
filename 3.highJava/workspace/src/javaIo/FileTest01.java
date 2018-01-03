package javaIo;

import java.io.File;

public class FileTest01 {
	// file객체 만들기 연습

	// 1.new file(String 파일 또는 경로)
	// -> 디렉토리와 디렉토리 사이, 또는 디렉토리와 파일면 사이의 구분문자는
	// -> \/를 사용 할 수 있다.

	public static void main(String[] args) {
		File file = new File(
				"D:\\eszett_study\\3.highJava\\workspace\\test.txt");
		System.out.println(file.getName());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println();

		File file2 = new File("/");
		System.out.println(file2.getName());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
		System.out.println();

		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName());
		System.out.println(file3.length());
		System.out.println();

		File file4 = new File(file3.getParent(), "test.txt");
		System.out.println(file4.getAbsolutePath());

		// ----------------------------------------------------//
		// 디렉토리 만들기
		// 1.mkdir() ->파일 객체가 가지고 있는 전체 경로 중 마지막 위치의 디렉토리를 만든다.
		// ->이 명령은 중간의 경로가 모두 미리 만들어져 있어야 한다.
		// 2.mkdirs()->파일객체가 가지고 있는 전체 경로중 마지막위치의 디렉토리를 만든다.
		// ->이 명령은 중간의 경로가 없으면 중간의 경로도 만들어준다.

		File file5 = new File("D:\\eszett_study\\3.highJava\\workspace\\study");
		if (!file5.exists()) {
			if (file5.mkdir()) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} else {
			System.out.println("존재하는 파일입니다.");
		}
		System.out.println();

		File file6 = new File(
				"D:\\eszett_study\\3.highJava\\workspace\\temp\\src");
		if (!file6.exists()) {
			if (file6.mkdir()) {
				System.out.println("mkdir()성공");
			} else {
				if (!file6.mkdirs()) {
					System.out.println("실패");
				} else {
					System.out.println("mkdirs() 성공");
				}
			}
		} else {
			System.out.println("존재하는 파일입니다.");
		}
		System.out.println();

	}
}
