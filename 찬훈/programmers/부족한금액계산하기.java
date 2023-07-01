class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        answer =  -1L * money + ((1L * count * (count + 1L)) / 2L) * price;
        
        if(answer <= 0) {
            return 0;
        } 

        return answer;
    }
}
