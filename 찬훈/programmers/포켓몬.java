import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = nums.length / 2;
        
        for (int num: nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), count);
    }
}
