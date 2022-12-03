package level1;

public class 비밀지도_1차 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            java.util.List<String> answer = new java.util.ArrayList<>();

            for (int i = 0; i < n; i++) {
                int sum = Integer.parseInt(Integer.toBinaryString(arr1[i])) + Integer.parseInt(Integer.toBinaryString(arr2[i]));
                String naisyo = "";

                while (sum >= 1) {
                    if (sum % 10 == 0) naisyo += " ";
                    else naisyo += "#";
                    sum /= 10;
                }
                answer.add(reverse(naisyo));
            }

            return answer.toArray(new String[answer.size()]);
        }

        private String reverse(String str){
            String reverse = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reverse = reverse + str.charAt(i);
            }
            return reverse;
        }
    }


    public static void main(String[] args) {
        String str = " ### ";

        StringBuilder reverse = new StringBuilder(str);
//        for (int i = str.length() - 1; i >= 0; i--) {
//            reverse.append(str.charAt(i));
//        }

        String answer = reverse.reverse().toString();
        System.out.println(answer);
    }

}
