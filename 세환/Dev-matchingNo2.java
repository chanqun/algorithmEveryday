import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	static int [] d = new int[31];
	static boolean[] check = new boolean[31];
    public int solution(int leave, String day, int[]holidays ) {
        
        for (int i = 0; i < holidays.length; i++) {
			check[holidays[i]] = true;
		}
        
        Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < days.length; i++) {
			if (days[i].equals(day)) {
				for (int j = i; j < i + days.length; j++) {
					int idx = j >= days.length ? j - days.length : j;
					q.add(days[idx]);
				}
			}
		}
        
        for (int i = 1; i <= 30; i++) {
			Queue<String> copyQ = new LinkedList<String>(q);
			int result = 0;
			
			int l = leave;
			for (int j = i; j <= 30; j++) {
				String dd = copyQ.poll();
				if ("SAT".equals(dd) || "SUN".equals(dd) || check[j]) {
					
				} else {
					if (l == 0 ) break;
					l--;
				}
				result++;
				copyQ.add(dd);
			}
			
			d[i] = result;
			String next = q.poll();
			q.add(next);
		}
        
        int answer = -1;
        for (int i : d) {
			answer = Math.max(answer, i);
		}
        
        return answer;
    }
}