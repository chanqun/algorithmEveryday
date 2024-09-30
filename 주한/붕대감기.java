class Solution {
    private int answer;
    public int solution(int[] bandage, int health, int[][] attacks) {
        answer = health;
        int[] previousAttack = {0, 0};
        for(int[] attack: attacks){
            int duration = attack[0] - previousAttack[0] - 1;
            healing(duration, bandage, health);
            attacked(attack[1]);
            if(answer <= 0){
                return -1;
            }
            changeNowAttackToPrevious(previousAttack, attack);
        }
        return answer;
    }

    private void addSecondHealing(int duration, int healingPerSecond){
        answer += duration * healingPerSecond;
    }

    private void successSucceed(int duration, int[] bandage){
        int succeed = duration / bandage[0];
        if(succeed > 0){
             answer += (succeed * bandage[2]);
        }
    }

    private void attacked(int damage){
        answer -= damage;
    }
    
    private void healing(int duration, int[] bandage, int health){
        if(duration > 0){
            addSecondHealing(duration, bandage[1]);
            successSucceed(duration, bandage);
            if(answer >= health){
                answer = health;
            }
        }
    }
    
    private void changeNowAttackToPrevious(
        int[] previousAttack, int[] nowAttack){
        previousAttack[0] = nowAttack[0];
        previousAttack[1] = nowAttack[1];
    }
}
