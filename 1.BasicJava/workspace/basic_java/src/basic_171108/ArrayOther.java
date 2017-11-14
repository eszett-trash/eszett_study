package basic_171108;


class arraytemp {

	public static void multiArray() {
		/*
		 * 1. 다차원 배열 -자바에서는 1차원 배열뿐만이 아니라 2차원 이상의 다차원 배열도 허용한다. - 2차원 배열 타입[][]
		 * 변수명 int [][]score 타입 변수명 [][] int score[][] 타입[] 변수명[] int[] score[];
		 */

		// int[][] score = new int[3][];
		// score[0] = new int[2];

		int[][] score = new int[4][3];
		int temp = 0;
		for (int i = 0; i < score.length; i++) {

			for (int j = 0; j < score[i].length; j++) {
				temp += 10;
				score[i][j] = temp;
			}

		}
		for (int i = 0; i < score.length; i++) {

			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();

		}

	}

	public static void multiArrayReal() {

		
		//성적입력프로그램
		String[] ob = { "국어", "영어", "수학", "사회", "과학", "자바", "HTML" };
		String[] sj = { "합계", "평균", "석차" };
		String[] name = { "문재인","추미애", "김무성", "유승민", "안철수", "홍준표"};
		String[] sjF = { "과목합계", "과목평균" };
		int[][] score = new int[name.length][ob.length]; // 위에잇는걸로 수정하고

		int[] sum = new int[name.length];
		float[] avr = new float[name.length];

		int[] rank = new int[name.length];

		int[] obsum = new int[ob.length];
		float[] obavr = new float[ob.length];

		
		// 성적입력
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = (int) (Math.random() * 101);
			}
		}

		// 합계
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				sum[i] += score[i][j];
			}

		}
		// 평균
		for (int i = 0; i < score.length; i++) {
			avr[i] = (int) (((float) sum[i] / score.length) * 100 + 0.5) / 100f;
		}

		// 과목합계
		 for (int i = 0; i < ob.length; i++) {
			 for (int j = 0; j < name.length; j++) {
				 obsum[i]+=score[j][i];
			 }
		 }
		//
		// 과목평균
		 for (int i = 0; i < ob.length; i++) {
			 for (int j = 0; j < name.length; j++) {
				 obavr[i] = (int) (((float) obsum[i] / score.length) * 100 + 0.5) / 100f;
			 }
		 }
		// sum에 복사

		for (int i = 0; i < name.length; i++) {
			rank[i] = sum[i];
		}

		int cnt;
		// sum에서 max가 있는 위치의 방 값을 반환받
		for (int i = 0; i < name.length; i++) {
			cnt = 1;
			for (int j = 0; j < name.length; j++) { // 최대값이 든 방번호를 찾음
				if (sum[i] < sum[j]) {
					cnt++;
				}
			}
			rank[i] = cnt;
		}

		/***** 출력 *************************************************************************************************************************/
		System.out.println("\n\n\n\n\n\n\n========기본 출력============================\n\n\n");
		for (int i = 0; i < ob.length; i++) {
			if (i == 0) {
				System.out.print("\t|\t");
			}
			System.out.print(ob[i] + "\t");
		}
		for (int i = 0; i < sj.length; i++) {
			System.out.print(sj[i] + "\t");
		}

		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "\t|\t");
			for (int j = 0; j < ob.length; j++) {

				System.out.print(score[i][j] + " \t");
			}
			System.out.print(sum[i] + "\t");
			System.out.print(avr[i] + "\t");
			System.out.print(rank[i] + "\t");
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		System.out.print(sjF[0] + "|\t");
		for (int j = 0; j < ob.length; j++) {
			System.out.print(obsum[j] + " \t");
		}
		System.out.println();
		System.out.print(sjF[1] + "|\t");
		for (int j = 0; j < ob.length; j++) {
			System.out.print(obavr[j] + " \t");
		}
		
		//여기에 소트하기
		
		
		
		
		int index;
		int aa = 0;
		float aatemp = 0.0f;
		String aasttemp = "";
		
		int aatmp = 0;
		//성적을 이름에 딸려서 위치 바꾸기
		
		
		System.out.println(ob.length);
		//합계평균랭크이름 바꾸기
		for (int i = 0; i < name.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < name.length; j++) {
				if (sum[j] > sum[index]) {
					index = j;
				}
			}
			
			// 합계 기준으로 변경
			aa = sum[index];
			sum[index] = sum[i];
			sum[i] = aa;

			// 평균도 위치 변경
			aatemp = avr[index];
			avr[index] = avr[i];
			avr[i] = aatemp;

			// 랭크도 위키 바꾸기
			aa = rank[index];
			rank[index] = rank[i];
			rank[i] = aa;

			// 이름도 위치 바꾸기
			aasttemp = name[index];
			name[index] = name[i];
			name[i] = aasttemp;
			
			for (int k = 0; k < ob.length; k++) {
				aatmp = score[i][k];
				score[i][k] = score[index][k];
				score[index][k] = aatmp;
				}
						
		}		
		

			
		/***** 출력 *************************************************************************************************************************/
		
		System.out.println("\n\n\n\n\n\n\n========셀렉트소트============================\n\n\n");
		for (int i = 0; i < ob.length; i++) {
			if (i == 0) {
				System.out.print("\t|\t");
			}
			System.out.print(ob[i] + "\t");
		}
		for (int i = 0; i < sj.length; i++) {
			System.out.print(sj[i] + "\t");
		}

		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "\t|\t");
			for (int j = 0; j < ob.length; j++) {

				System.out.print(score[i][j] + " \t");
			}
			System.out.print(sum[i] + "\t");
			System.out.print(avr[i] + "\t");
			System.out.print(rank[i] + "\t");
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		System.out.print(sjF[0] + "|\t");
		for (int j = 0; j < ob.length; j++) {
			System.out.print(obsum[j] + " \t");
		}
		System.out.println();
		System.out.print(sjF[1] + "|\t");
		for (int j = 0; j < ob.length; j++) {
			System.out.print(obavr[j] + " \t");
		}


	}
}

public class ArrayOther {
	public static void main(String[] args) {
		arraytemp.multiArrayReal();
	}
}
