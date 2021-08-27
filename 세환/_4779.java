import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			StringBuffer result = new StringBuffer();
			result.append("-");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String val = result.toString();
				for (int j = 0; j < val.length(); j++) {
					result.append(" "); 
				}
				result.append(val);
			}
			System.out.println(result);
		}
	}
}
