import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H = 0;
	static int W = 0;
	
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String blockVal = br.readLine();
		StringTokenizer st = new StringTokenizer(blockVal);
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		int result = 0, left, right;
		for(int i = 0; i < W; i++) {
			int b = Integer.parseInt(st.nextToken());
			arr[i] = b;
		}
        
        for (int i = 1; i < W - 1; i++) {
            left = 0;
            right = 0;
            
            for (int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }
            
            for (int j = i + 1; j < W; j++) {
                right = Math.max(arr[j], right);
            }
            
            if (arr[i] < left && arr[i] < right) {
                result += Math.min(left, right) - arr[i];
            }
        }
		
		System.out.println(result);
	}
}
