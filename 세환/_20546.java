import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine()); 
		int j = money; 
		int s = money;
		
		int []arr = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		while(st.hasMoreElements()) {
			arr[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		
		int jCount = 0;
		int sCount = 0;
		
		int sMax = 0;
		int sMin = 0;
		
		int checkNum = 0;
		// 준현이는 구매가 가능한 첫날 매수 후 마지막날 매도한다.
		for (int i = 0; i < idx; i++) {
			if (i != 0 ) checkNum = arr[i - 1];
			// 마지막 날 매도
			if (i == idx - 1) {
				j += jCount * arr[i];
				s += sCount * arr[i];
				break;
			}
			
			// 구매 가능한 금액에서 매수
			if (arr[i] <= j) {
				jCount = j / arr[i];
				j -= jCount * arr[i];
			}
			
			if (checkNum < arr[i]) {
				sMax++;
				sMin = 0;
			} else if (checkNum > arr[i]) {
				sMin++;
				sMax = 0;
			}
			
			if (sMin >= 3 && s >= arr[i]) {
				sCount += s / arr[i];
				s -= (s/arr[i]) * arr[i];
			}
			if (sMax == 3) {
				s += sCount * arr[i];
				sCount = 0;
			}
		}
		System.out.println(j > s ? "BNP" : j == s ? "SAMESAME" : "TIMING");
	}
}