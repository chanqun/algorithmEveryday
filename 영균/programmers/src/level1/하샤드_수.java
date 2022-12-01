package level1;

import java.util.ArrayList;
import java.util.List;

public class 하샤드_수 {
// 하샤드 수 = x의 자릿수의 합으로 x가 나누어져야 합니다.

    class Solution {
        public boolean solution(int x) {
            int sum = xList(x).stream().mapToInt(num -> num).sum();
            if (x % sum > 0) {
                return false;
            }

            return true;
        }

        private List<Integer> xList(int num) {
            ArrayList<Integer> temp = new ArrayList<>();
            while(num >= 1) {
                temp.add(num %10);
                num /= 10;
            }
            return temp;
        }
    }
}
