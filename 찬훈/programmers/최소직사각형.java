class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int bigNum = 0;
        int smallNum = 0;
        
        for (int[] size: sizes) {
            int maxNum = Math.max(size[0], size[1]);
            int minNum = Math.min(size[0], size[1]);
            
            bigNum = Math.max(bigNum, maxNum);
            smallNum = Math.max(smallNum, minNum);
        }
        
        answer = bigNum * smallNum;
        
        return answer;
    }
}
