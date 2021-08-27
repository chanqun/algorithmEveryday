import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean check = true;
		
		Stack<String> stack = new Stack<>();
		
		String result = "";
		
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='<') {
				check = false;
				
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				result += "<";
			}
			else if (s.charAt(i)=='>') {
				check = true;
				
				result += ">";
			}
			else if (s.charAt(i)==' ') {
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				result += " ";
			}
			else {
				if(check) {
					stack.push(String.valueOf(s.charAt(i)));
				} else {
					result += String.valueOf(s.charAt(i));
				}
			}
		}
		
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.print(result);
	}
}
