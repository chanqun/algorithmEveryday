import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int [] check = new int [1000];
	
	private static void checkNum (String input) {
		String [] inputArr = input.split(" ");
		String [] inputNum = inputArr[0].split("");
		int strike = Integer.parseInt(inputArr[1]);
		int ball = Integer.parseInt(inputArr[2]);
		
		for(int i = 111; i < 1000; i++) {
			int strikeCount = 0;
			int ballCount = 0;
			String[] num = String.valueOf(i).split("");

			// 조건처리 어떤식으로 하면 좋을까??..
			if (checkContinue(num)) { 
				continue;
			}
			for (int j = 0; j < 3; j++) {
				if(num[j].equals(inputNum[j])) {
					strikeCount++;
					continue;
				}
				for (int k = 0; k < 3; k++) {
					if(num[j].equals(inputNum[k])) {
						ballCount++;
						continue;
					}
				}
			}
			
			if(strike == strikeCount && ballCount == ball) {
				check[i]++;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int question = Integer.parseInt(br.readLine());
		for(int i = 0; i < question; i++) {
			String input = br.readLine();
			checkNum(input);
		}
		
		int result = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i] == question) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static boolean checkContinue (String [] num) {
		return (num[0].equals(num[1]) || num[0].equals(num[2]) || num[2].equals(num[1]) || (num[0].equals("0") || num[1].equals("0") || num[2].equals("0")));
	}
}
