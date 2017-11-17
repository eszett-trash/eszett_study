package night_171025;

class OneTwoFour {
	
	
	public String change124(int n) {
		String answer = "0";
		int temp = n;
		while (true) {
			
			if(temp%3==0)
			{
				temp-=3;
				answer+=4;
			}
			else
			{
				temp-=(temp%3);
				answer+=(temp%3);
			}
			
			if(temp<=3)
			{
				answer+=temp;
				break;
			}
		}
		
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(10));
	}
}
