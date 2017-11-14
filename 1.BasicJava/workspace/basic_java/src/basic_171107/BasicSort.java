package basic_171107;

import java.util.Arrays;

class Sort {
	public static void bubbleSort() {
		/*
		 * 2.버블소트 -인접한 데이터간에 교환이 계속해서 일어나면서 정렬이 된다. -한 회전이 끝나면 가장 큰 값이 뒤로 보내짐
		 */

		System.out.println("\n\n==========================버블소트==============================");
		int[] temp = { 5, 2, 3, 1, 4 };
		int tmp = 0;

		for (int i = 0; i < temp.length - 1; i++) {
			System.out.println("\n" + (i + 1) + "회전");
			for (int j = 0; j < temp.length - (i + 1); j++) {
				if (temp[j] > temp[j + 1]) {
					tmp = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = tmp;
				}
				for (int k = 0; k < temp.length; k++) {
					System.out.print(temp[k]);
				}
				System.out.println();
			}
		}

	}

	public static void selectSort() {
		/*
		 * 4. 셀렉트 소트 -정렬의 대상에서 최소값을 찾아서 맨 앞의 내용과 교체하는 방식이다.
		 * 
		 * -0번방 기준 -최소값을 구한다 -최소값이 위치한 방 번호를 얻어내고 -0번방 값과 최소값 값을 바꿈
		 * 
		 * -1번방 기준으로 다시돌림
		 */
		System.out.println("\n========셀렉트소트============================");
		int[] temp = { 5, 2, 3, 1, 4, 54, 12, 4, 1, 0, 3, 543, 1, 2, 4, 9 };
		int index;
		int aa = 0;

		// 기준을 세우고 기준과 비교해서 뒤에 같
		for (int i = 0; i < temp.length - 1; i++) {
			index = i;
			System.out.println(Arrays.toString(temp));
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[j] < temp[index]) {
					index = j;
				}
			}
			aa = temp[index];
			temp[index] = temp[i];
			temp[i] = aa;

		}
	}

	public static void insertSort() {
		/*
		 * 3.인서트 소트 -정렬한 대상을 하나씩 늘려가면서 정렬이 필요한 요소를 선택 해 적절한 위치에 삽입 해 가는 과정이다.
		 * -가장 작은값을 앞으로 가져온다.
		 */
		System.out.println("\n\n========인서트소트==============================");
		int[] temp = { 5, 2, 3, 1, 4 };
		for (int i = 1; i < temp.length ; i++) {

			int a = i - 1;
			int b = temp[i];

			while ((temp[a] > b) && (a >= 0)) {

				temp[a + 1] = temp[a];
				a--;
			}
			temp[a + 1] = b;
		}
		System.out.println(Arrays.toString(temp));
	}
}

public class BasicSort {
	public static void main(String[] args) {
		/*
		 * 1.정렬 -어떤 데이터를 빠르고 쉽게 찾기 위해 일정한 순서대로 데이터를 가지런히 나열하는 작업 -버블소트 인서트소트
		 * 셀렉트소트정도가 대표적
		 */

		Sort.insertSort();

	}
}
