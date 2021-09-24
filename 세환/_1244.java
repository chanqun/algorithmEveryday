import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] S;
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
        S = new int [len + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        
        int human = Integer.parseInt(br.readLine());
        for (int i = 0; i < human; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            
	            // 남자의 경우
	            if (gender == 1) {
	               for (int j = number; j <= len; j += number) {
            		   S[j] = S[j] == 1 ? 0 : 1;
	               }
	            } 
	            // 여자의경우
	            else {
	            	if ((number == 1 || number == len) || S[number - 1] != S[number + 1]) {
	            		S[number] = S[number] == 1 ? 0 : 1;
	            	} else {
	            		int left = number - 1;
	            		int right = number + 1;
	            		S[number] = S[number] == 1 ? 0 : 1;
	            		while (left > 0 && right <= len) {
	            			if (S[left] == S[right]) {
	            				S[left] = S[left] == 1 ? 0 : 1;
	            				S[right] = S[right] == 1 ? 0 : 1;
	            				--left;
	            				++right;
	            			} else {
	            				break;
	            			}
	            		}
	            	}
	            }
            }
        
       
        for (int i = 1; i <= len; i++) {
            System.out.print(S[i] + " ");
            if (i % 20 == 0) {
            	System.out.println();
            }
        }
    }
}