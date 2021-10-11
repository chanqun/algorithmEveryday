import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int fileLen = Integer.parseInt(br.readLine());
		String [] fileName = new String [fileLen];
		
		for (int i = 0; i < fileLen; i++) {
			fileName[i] = br.readLine();
		}
		
		String answer = "";
		for (int i = 0; i < fileName.length; i++) {
			String file = fileName[i];
			
			for (int j = 0; j < fileName.length; j++) {
				boolean check = true;
				if (file.length() == fileName[j].length()) {
					for (int k = 0; k < fileName[j].length(); k++) {
						if (file.charAt(k) != fileName[j].charAt(fileName[j].length() - 1 - k)) {
							check = false;
						}
					}
				}
				
				if (check) {
					answer = fileName[j];
					break;
				}
			}
		}
		
		System.out.println(answer.length() + " " + answer.charAt(answer.length() / 2));
	}
}