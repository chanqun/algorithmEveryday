import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0];
        int amount = bandage[1];
        int additional = bandage[2];
        int nowHealth = health;
        
        int nowTime = 0;
        
        for (int[] attack: attacks) {
            int time = attack[0];
            int damage = attack[1];
            
            int addTime = time - nowTime - 1;

            nowHealth += (addTime / t) * additional;
            nowHealth += (addTime * amount);
            
            nowHealth = Math.min(health, nowHealth);
            
            nowTime = time;
            nowHealth -= damage;
            
            if (nowHealth <= 0) {
                return -1;
            }
        }
        
        answer = nowHealth;
        
        return answer;
    }
}
