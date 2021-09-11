// 카카오 코테 1번문제

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main (String [] args) {
		
		String [] id_list = {"muzi", "frodo", "apeach", "neo"};
		String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int  k = 2;
		int [] answer = new int[id_list.length];
		int [] check = new int [id_list.length];
		
		Map<String, Set<String>> map = new HashMap<>();
		
		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], new HashSet<String>());
		}
		
		for (int i = 0; i < report.length; i++) {
			String [] str = report[i].split(" ");
			map.get(str[0]).add(str[1]);
		}
		
		
		for (int i = 0; i < map.size(); i++) {
			Iterator<String> str = map.get(id_list[i]).iterator();
			while (str.hasNext()) {
				String reportName = str.next();
				for (int j = 0; j < id_list.length; j++) {
					if (reportName.equals(id_list[j])) {
						check[j]++;
					}
				}
			}
		}
		
		for (int i = 0; i < check.length; i++) {
			if (k <= check[i]) {
				String stopUser = id_list[i];
				for (int j = 0; j < map.size(); j++) {
					Iterator<String> str = map.get(id_list[j]).iterator();
					while (str.hasNext()) {
						if (stopUser.equals(str.next())) {
							answer[j]++;
						}
					}
				}
			}
		}
		
		for (int i : answer) {
			System.out.print(i + " ");
		}
		
	}
}