package me.kzv.pccp;

public class 붕대감기 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            final int maxHealth = health; // 최대 체력은 초기 체력까지
            final int castingTime = bandage[0];
            final int defaultRecovery = bandage[1];
            final int bonusRecovery = bandage[2];
            // 시전 시간 마지막까지 가면 추가 회복을 받음
            // 최대 회복량 = (회복시간 * 회복량) + (회복시간 / 시전시간  * 보너스 회복량)

            int curTime = 0;
            for (int[] attack : attacks) {
                final int attackTime = attack[0];
                final int attackDamage = attack[1];

                final int recoveredTime = (attackTime - 1) - curTime; // 회복한 시간은 공격 시간 전까지이므로 -1
                health += (recoveredTime * defaultRecovery) + (recoveredTime / castingTime * bonusRecovery);

                health = Math.min(health, maxHealth); // 처음에는 if문으로 비교 했는데 Math.min 으로 비교하면 더 간결함
                health -= attackDamage;
                curTime = attackTime;

                if(health <= 0) {
                    health = -1;
                    break;
                }
            }

            return health;
        }
    }
}
