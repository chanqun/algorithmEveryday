import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
	private static int N = 0;
	private static int W = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int [] cost = new int[N];
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		int min = cost[0];
		int max = cost[0];
		
		long money = W;
		long maxMoney = W;
		
		for (int i = 1; i < N; i++) {
			if (cost[i] > max) {
				max = cost[i];
				maxMoney = money + ((money / min) * (max - min));
			}
			
			if (max > cost[i]) {
				min = cost[i];
				max = cost[i];
				money = maxMoney;
			}
		}
		
		money = maxMoney;
		System.out.println(money);
	}
}

