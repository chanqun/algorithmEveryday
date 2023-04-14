import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String s : callings) {
            int index = map.get(s);
            
            map.put(s, index - 1);
            map.put(players[index - 1], index);
            
            players[index] = players[index - 1];
            players[index - 1] = s;
        }

        return players;
    }
}
