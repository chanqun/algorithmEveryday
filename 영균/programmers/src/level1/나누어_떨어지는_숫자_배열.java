package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i : arr) if (i % divisor == 0) list.add(i);

            if(list.size() == 0){
                return new int[]{-1};
            }else{
                return list.stream().sorted()
                        .mapToInt(Integer::intValue)
                        .toArray();
            }
        }

        public int[] solution2(int[] arr, int divisor) {
            int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).sorted().toArray();

            if (answer.length == 0) {
                return new int[]{-1};
            }else{
                return answer;
            }
        }
    }
}
