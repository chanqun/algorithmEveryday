public class Main {
    public static void main(String[] args) {
        String[] sList = {"12223", "111999333", "123"};
        Solution solution = new Solution();

        for (String s : sList) {
            int answer = solution.solution(s);

            System.out.println(answer);
        }
    }

    static class Solution {
        String[] numList = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};

        public int solution(String s) {
            int maxNum = -1;

            for (String num : numList) {
                if (s.contains(num)) {
                    maxNum = Integer.parseInt(num);
                }
            }

            return maxNum;
        }
    }
}

