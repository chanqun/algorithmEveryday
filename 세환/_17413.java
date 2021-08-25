import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean check = true;
		String [] arr = new String[s.length()];
		
		Stack<String> stack = new Stack<>();
		
		String result = "";
		
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i, i+1);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("<")) {
				check = false;
				
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				result += "<";
			}
			else if (arr[i].equals(">")) {
				check = true;
				
				result += ">";
			}
			else if (arr[i].equals(" ")) {
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				result += " ";
			}
			else {
				if(check) {
					stack.push(arr[i]);
				} else {
					result += arr[i];
				}
			}
		}
		
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.print(result);
	}
}
