import java.util.*;

class Solution {
    int nowDirection = 0;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    int y = 0;
    int x = 0;
    
    public int[] solution(String command) {
        int[] answer = new int[2];
        
        for (int i=0; i<command.length(); i++) {
            char nowCommand = command.charAt(i);
            
            action(nowCommand);
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
    
    private void action(char nowCommand) {
        if (nowCommand == 'R') {
            nowDirection = (nowDirection + 5)%4;
        }
        
        if (nowCommand == 'L') {
            nowDirection = (nowDirection + 3)%4;
        }

        if (nowCommand == 'G') {
            y += dy[nowDirection];
            x += dx[nowDirection];
        }
        
        if (nowCommand == 'B') {
            y -= dy[nowDirection];
            x -= dx[nowDirection];
        }
    }
}

