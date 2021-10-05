import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrSize = Integer.parseInt(st.nextToken()); // 돌림판 크기
			int numSize = Integer.parseInt(st.nextToken()); // 비교 할 숫자 길이
			
			int answer = 0;
			
			int x = Integer.parseInt(br.readLine().replaceAll(" ", ""));
			int y = Integer.parseInt(br.readLine().replaceAll(" ", ""));
			int[] arr = new int[arrSize];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arrSize; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < arr.length; j++) {
				int check = 0;
				for (int k = 0; k < numSize; k++) {
					int idx = j + k < arrSize ? j + k : j + k - arrSize;
					check = check * 10 + arr[idx];
				}
				
				if (check >= x && check <= y) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}