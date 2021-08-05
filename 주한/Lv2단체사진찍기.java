package algorithm.kakao;

public class Lv2단체사진찍기 {
    public static int solution(int n, String[] data) {
        permutation(0,data);
        return answer;
    }

    static char[] array = new char[8];
    static char [] letters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean visited[]= new boolean[8];
    static int answer = 0;
    public static void permutation(int index,String[] data){
        if(index == 8) {
            boolean flag = false;
            for(String str: data){
                char letter1 = str.charAt(0);
                char letter2 = str.charAt(2);
                int index1 = 0;
                int index2 = 0;
                char sign = str.charAt(3);
                int diff = str.charAt(4)-'0';

                for(int j =0; j< array.length; j++){
                    if(array[j] == letter1) index1 = j;
                    if(array[j] == letter2) index2 = j;
                }


                if(sign == '<'){
                    if(Math.abs(index1-index2) < diff+1) flag = true;
                    else {
                        flag = false;
                        break;
                    }
                } else if (sign == '>') {
                    if(Math.abs(index1-index2) > diff+1) flag = true;
                    else {
                        flag = false;
                        break;
                    }
                } else if (sign == '=') {
                    if(Math.abs(index1-index2) == diff+1) flag = true;
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                answer++;
            }
        }
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                array[index] = letters[i];
                permutation(index + 1,data);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));//3648
    }
}