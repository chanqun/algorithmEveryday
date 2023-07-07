class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = 0;
        int maxX = 0;
        
        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                char c = wallpaper[i].charAt(j);
                
                if (c=='#') {
                    minY = Math.min(minY, i);
                    
                    minX = Math.min(minX, j);
                    
                    maxY = Math.max(maxY, i);
                    
                    maxX = Math.max(maxX, j);
                }
            }
        }
        
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;
        
        return answer;
    }
}
