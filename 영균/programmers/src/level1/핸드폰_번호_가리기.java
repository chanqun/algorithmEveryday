package level1;

public class 핸드폰_번호_가리기 {
    class Solution {
        public String solution(String phone_number) {
            String answer = "";
            for (int i = 0; i < phone_number.length() - 4; i++) {
                answer += "*";
            }
            return answer + phone_number.substring(phone_number.length() - 4);
        }

        // 정규식 이용시
        public String solution2(String phone_number) {
            return phone_number.replaceAll(".(?=.{4})", "*");
        }

        // char 배열을 이용해서
        public String solution3(String phone_number) {
            char[] ch = phone_number.toCharArray();
            for(int i = 0; i < ch.length - 4; i ++){
                ch[i] = '*';
            }
            return String.valueOf(ch);
        }
    }
}
