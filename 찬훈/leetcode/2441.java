import java.util.*;

class Solution {
    public int findMaxK(int[] nums) {
        int answer = -1;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for (int num: nums) {
            if (set.contains(-num)) {
                answer = Math.max(answer, Math.abs(num));
                continue;
            }

            set.add(num);
        }

        return answer;
    }
}
