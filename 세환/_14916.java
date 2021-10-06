import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int count = 0;
		
		/** 내가 만든 구데기 코드 */
//		if ( (money % 5) % 2 == 0 ) {
//			count += money / 5;
//			money = money % 5;
//			count += money / 2;
//		} else {
//			if (money > 3) {
//				count += money / 5 - 1;
//				money = (money % 5) + 5;
//				count += money / 2;
//			} else {
//				count += money / 2;
//			}
//		}
//		
//		if (money % 2 != 0) {
//			count = -1;
//		}
		
		/** 블로그 참조 */
		if (money % 5 == 0) {
			count = money / 5;
		} else {
			while (true) {
				if (money < 0) {
					count = -1;
					break;
				}
				
				if (money % 5 != 0) {
					money -= 2;
					count++;
				} else {
					count += money / 5;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}