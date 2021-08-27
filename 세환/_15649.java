import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	private static int [] ARR;
	private static boolean [] VISIT;
	private static int [] RESULT;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ARR = new int[n];
		VISIT = new boolean[n];
		RESULT = new int[n];
		
		for (int i = 0; i < n; i++) {
			ARR[i] = i+1;
		}
		permutation(0, n, m);
	}
	
	public static void permutation (int idx, int nn, int mm) {
		if (idx == mm) {
			for (int i = 0; i < mm; i++) {
				System.out.print(RESULT[i]+" ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < nn; i++) {
				if (!VISIT[i]) {
					VISIT[i] = true;
					RESULT[idx] = ARR[i];
					permutation(idx + 1, nn, mm);
					VISIT[i] = false;
					RESULT[idx] = 0;
				}
			}
		}
	}
}
