import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 하노이탑 공식
	// 1 -> 3 -> 2
	// 2 -> 1 -> 3
	public static void hanoi (int inputNum, String head, String body, String tail) {		
		if(inputNum == 1) {
			System.out.println(head + " " + tail);
			return;
		}
		
		hanoi (inputNum - 1, head, tail, body);
		System.out.println(head + " " + tail);
		hanoi (inputNum - 1, body, head, tail);
		
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String head = "1";
		String body = "2";
		String tail = "3";
		BigInteger count = BigInteger.ONE;
		
		for (int i = 0; i < N; i++) {
			count = count.multiply(BigInteger.valueOf(2));
		}
		
		System.out.println(count.subtract(BigInteger.valueOf(1)));
		
		if (N <= 20) {
			hanoi(N, head, body, tail);
		}
	}
}
