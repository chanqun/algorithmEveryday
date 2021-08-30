import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Job> list = new ArrayList<>();
		for (int i = 0; i <= n + 1; i++) {
			if (i == 0 || i == n + 1) {
				list.add(new Job(0, 0));
				continue;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			
			list.add(new Job(day, money));
		}
		
		int[] dp = new int [n+2];
		int next = 1;
		int max = -1;
		for (int i = 1; i <= n + 1; i++) {
			int day = list.get(i).getDay();
			int money = list.get(i).getMoney();
			
			max = Math.max(max, dp[i]);
			next = i + day;
			
			if (next <= n + 1) {
				dp[next] = Math.max(dp[next], max + money);
			}
		}
		
		System.out.println(max);
	}
}

class Job {
	private int day;
	private int money;
	
	public Job() {}
	
	public Job(int day, int money) {
		this.day = day;
		this.money = money;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return this.day + " : " + this.money;
	}
}

