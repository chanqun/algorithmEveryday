import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sList = s.replace("},{", " ").split(" ");
        
        Queue<List<String>> q = new LinkedList<>();
        
        for (String str: sList) {
            String[] strList = str.split(",");
            List<String> list = new ArrayList<>();
            
            for (String str2: strList) {
                list.add(str2);
            }
            
            q.add(list);
        }
        
        Set<String> set = new HashSet<>();
        List<Integer> answerList = new ArrayList<>();
        int count = 1;
        
        while(!q.isEmpty()) {
            var list = q.poll();
            if (list.size() == count) {
                for (String temp: list) {
                    if (set.contains(temp)) {
                        continue;
                    }
                    
                    set.add(temp);
                    answerList.add(Integer.parseInt(temp));
                }
                
                count++;
                continue;
            }
            q.add(list);
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}

