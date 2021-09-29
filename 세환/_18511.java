import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int result = 0;
	static int N, K;
	static List<Integer> list;
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for ( int i = 0; i < K; i++ ) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list = list.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
		
		dfs(0);
		System.out.println(result);
    }
	
	static void dfs(int now) {
		if (now > N) return;
		
		if (result < now) result = now;
		
		for (int i = 0; i < K; i++) {
			dfs(now * 10 + list.get(i));
		}
	}
}