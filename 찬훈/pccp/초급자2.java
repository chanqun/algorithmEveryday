import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        Map<String, Integer> map1 = makeMap(str1);
        Map<String, Integer> map2 = makeMap(str2);

        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }

        int total = 0;
        double common = 0.0;

        Set<String> keys = new HashSet<>();

        for (String key: map1.keySet()) {
            keys.add(key);
        }
        for (String key: map2.keySet()) {
            keys.add(key);
        }

        for (String key: keys) {
            int count1 = 0;
            int count2 = 0;

            if (map1.containsKey(key)) {
                count1 = map1.get(key);
            }

            if (map2.containsKey(key)) {
                count2 = map2.get(key);
            }

            common += Math.min(count1, count2);
            total += Math.max(count1, count2);
        }

        answer = (int)((common / total) * 65536);

        return answer;
    }

    private Map<String, Integer> makeMap(String str1) {
        Map<String, Integer> map = new HashMap<>();

        str1 = str1.toLowerCase();

        for (int i=0; i<str1.length() - 1; i++) {
            char temp1 = str1.charAt(i);
            char temp2 = str1.charAt(i + 1);

            if (temp1 >= 'a' && temp1 <= 'z' && temp2 >= 'a' && temp2 <= 'z') {
                String temp = String.valueOf(temp1) + String.valueOf(temp2);

                if (!map.containsKey(temp)) {
                    map.put(temp, 1);
                } else {
                    int count = map.get(temp);

                    map.put(temp, count + 1);
                }
            }
        }

        return map;
    }
}

