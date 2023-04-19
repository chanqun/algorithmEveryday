import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for (char c: skill.toCharArray()) {
            set.add(c);
        }
        
        for (String skillTree: skill_trees) {
            String str = "";
            
            for (char c: skillTree.toCharArray()) {
                if (set.contains(c)) {
                    str += String.valueOf(c);
                }
            }
            
            if (skill.startsWith(str)) {
                answer++;
            }
        }
        
        return answer;
    }
}

