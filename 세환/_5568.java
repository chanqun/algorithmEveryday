import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
	private static int N = 0;
	private static int K = 0;
	private static int[] ARR;
	private static boolean[] VISIT;
	private static int[] RESULT;
	private static Set<String> SET = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		ARR = new int[N];
		VISIT = new boolean[N];
		RESULT = new int[N];
		for (int i = 0; i < N; i++) {
			ARR[i] = Integer.parseInt(br.readLine());
		}
		
		permutation(0);
		System.out.println(SET.size());
		
	}
	
	public static void permutation (int idx) {
		if (idx == K) {
			String add = "";
			for (int i = 0; i < K; i++) {
				if (RESULT[i] != 0) {
					add += RESULT[i];
				}
			}
			SET.add(add);
		} else {
			for (int i = 0; i < N; i++) {
				if (!VISIT[i]) {
					VISIT[i] = true;
					RESULT[idx] = ARR[i];
					permutation(idx + 1);
					VISIT[i] = false;
					RESULT[idx] = 0;
				}
			}
		}
	}
}
