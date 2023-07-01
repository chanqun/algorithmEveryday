class Solution {
    public boolean solution(int x) {
        int temp = x;
        int divNum = 0;
        
        while (temp > 0) {
            divNum += temp % 10;
            temp /= 10;
        }
        
        return (x % divNum) == 0;
    }
}
