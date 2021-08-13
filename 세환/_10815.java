import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static int N = 0; // 상근이가 가진 카드 개수
	
	private static int M = 0; // 상근이의 카드숫자를 체크하기 위한 카드 개수

	private static int[] check = new int[500001];
	static List<Integer> nArr = new ArrayList<>();
	
	public static boolean check (int target) {
		int start = 0;
		int end = nArr.size() - 1;
		int mid = 0;
		
		boolean result = false;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (nArr.get(mid) == target) {
				result = true;
				break;
			}
			
			if (nArr.get(mid) > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String nVal = br.readLine();
		String nSplit[] = nVal.split(" ");
		
		for (int i = 0; i < nSplit.length; i++) {
			nArr.add(Integer.parseInt(nSplit[i]));
		}
		
		Collections.sort(nArr);
		
		M = Integer.parseInt(br.readLine());
		String mVal = br.readLine();
		String mSplit[] = mVal.split(" ");
		List<Integer> mArr = new ArrayList<>();
		
		for (int i = 0; i < mSplit.length; i++) {
			mArr.add(Integer.parseInt(mSplit[i]));
		}
		
		for (int i = 0; i < mArr.size(); i++) {
			boolean result = check(mArr.get(i));
			if(result) {
				check[i]++;
			};
		}
		
		for (int i = 0; i < mArr.size(); i ++) {
			System.out.print(check[i]+" ");
		}
	}
}
