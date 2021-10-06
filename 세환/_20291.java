import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
		
		Map<String, Integer> map = new TreeMap<>(comparator);
		
		for (int i = 0; i < n; i++) {
			String[] file = br.readLine().split("\\.");
			if (map.get(file[1]) == null) {
				map.put(file[1], 1);
			} else {
				map.put(file[1], map.get(file[1]) + 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}