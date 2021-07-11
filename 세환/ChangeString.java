package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		 System.out.println(
			value.replace("0", "zero")
				 .replace("one", "1")
		 	     .replace("two", "2")
		 	     .replace("three", "3")
		 	     .replace("four", "4")
		 	     .replace("five", "5")
		 	     .replace("six", "6")
		 	     .replace("seven", "7")
		 	     .replace("eight", "8")
		 	     .replace("nine", "9")
		 	  );
	}
}
