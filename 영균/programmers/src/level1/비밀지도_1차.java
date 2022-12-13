package level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class 비밀지도_1차 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            java.util.List<String> answer = new java.util.ArrayList<>();

            for (int i = 0; i < n; i++) {
                // https://park-youjin.tistory.com/17
                // 비트 논리연산자를 사용하면 더 간편하게 구할 수 있는데
                // 이걸 몰라서 값을 그냥 더해서 구별해 버렸다. 0(" ") or 1,2("#")
                long sum = Long.parseLong(Integer.toBinaryString(arr1[i])) + Long.parseLong(Integer.toBinaryString(arr2[i]));
                StringBuilder naisyo = new StringBuilder();

                // 뒤에서 부터 각 자릿수의 값을 변환하여 문자열로 합친 후 reverse
                while (sum >= 1) {
                    if (sum % 10 == 0) naisyo.append(" ");
                    else naisyo.append("#");
                    sum /= 10;
                }

                // binary 로 변경시 첫번째 값이 0인 경우 값이 유실되므로 n - naisyo.length 횟수 만큼 공백을 추가해 준다.
                if (naisyo.length() < n) naisyo.append(" ".repeat(n - naisyo.length()));
                answer.add(naisyo.reverse().toString());
            }

            return answer.toArray(new String[answer.size()]);
        }

//        private String reverse(String str){
//            String reverse = "";
//            for (int i = str.length() - 1; i >= 0; i--) {
//                reverse = reverse + str.charAt(i);
//            }
//            return reverse;
//        }

        // 비트 논리 연산자로 구별하고 16글자 뒤에서 필요한 부분만 잘라와서 앞자리에 0이 오는 경우를 방지했지만 성능은 오히려 더 느려졌다.
        public String[] solution2(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                StringBuilder naisyo = new StringBuilder();
                char[] chars = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i])).substring(16 - n).toCharArray();
                for (int e = 0; e < n; e++) {
                    if (chars[e] == '1') naisyo.append("#");
                    else naisyo.append(" ");
                }
                answer[i] = naisyo.toString();
            }

            return answer;
        }
    }
}