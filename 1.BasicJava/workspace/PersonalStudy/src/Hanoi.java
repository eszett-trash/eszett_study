import java.util.Arrays;

class Hanoi {
	public int[][] hanoi(int n) {
		// 2차원 배열을 완성해 주세요.
		int[][] answer = null;
		// n만큼 배열을 만들어서 각각 0~n-1까지의 번호를 준다
		// 1번부터 하나씩 뽑아서 오른쪽에 자기보다 작은 수가 있는지 체크 -> 없으면 다음으로 넘어감의 반복 (전부 빌 때 까지
		// 시행한다.)

		int top[][] = new int[3][n];
		int comp[] = new int[n];
		// 플레이트 할당해줌
		for (int i = 0; i < n; i++) {
			top[0][i] = i + 1;
			comp[i] = i + 1;
		}

	//	while (top[2] != comp) { // 3번 탑이 플레이트 개수만큼 차면 빠져나온다.
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < top[i].length; j++) {
					int temp = i + 1 > 3 ? i + 1 : 0;
					int swap = 0;
					if (top[i][j] < top[temp][j]) {
						System.out.println(top[i][j]+"   "+top[temp][j]);
						for (int k = 0; k < top.length; k++) {
							System.out.println(Arrays.toString(top[k]));
						}
						swap = top[i][j];
						top[i][j] = top[temp][j];
						top[temp][j] = swap;
						//앞의 빈공간을 전부 없앤다
						
					}
					System.out.println();
				}
			}
	//	}

		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		System.out.println(Arrays.toString(h.hanoi(10)));
	}
}
