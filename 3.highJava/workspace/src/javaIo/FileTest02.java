package javaIo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileTest02 {
	public static void main(String[] args) {
		displayFileList(new File("D:\\app\\PC07\\diag"));
	}

	public static void displayFileList(File dir) {
		System.out.println(dir.getAbsolutePath() + " || 디렉토리 내용");
		File[] files = dir.listFiles();

		ArrayList<Integer> subList = new ArrayList<Integer>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

		//권한없으면 nulL때 리턴시켜버리는 방식으로 권한검사를 실시
		if (files == null) {
			System.out.println("접근 권한이 없습니다.");
			return;
		}
		
		//디렉토리 이름 가져옴
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			String attr = "";
			String size = "";
			if (files[i].isDirectory()) {
				attr = "<DIR>";
				
			} else {
				size = files[i].length() + "\0";
				attr = files[i].canRead() ? "R" : "  ";
				attr += files[i].canWrite() ? "W" : "  ";
				attr += files[i].isHidden() ? "H" : "  ";
			}
			//재귀호출
			System.out.printf("%s %5s %12s %s\n",
					df.format(files[i].lastModified()), attr, size, fileName);
		}

		//출력
		int dirNum = subList.size();
		int fileNum = files.length - dirNum;

		System.out.println(fileNum + "개의 파일 , " + dirNum + "개의 디렉토리");
		System.out.println();
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]);
		}
	}
}
