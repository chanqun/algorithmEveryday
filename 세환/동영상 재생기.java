import java.util.*;

class Solution {
    int videoLen = 0;
    int posTime = 0;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        videoLen = changeSecond(video_len);
        posTime = changeSecond(pos);
        
        int opStart = changeSecond(op_start);
        int opEnd = changeSecond(op_end);
        
        String answer = "";
        
        for (int i = 0; i < commands.length; i++) {
            if (opStart <= posTime && opEnd >= posTime) {
                posTime = opEnd;
            }
            move(commands[i]);
        }
        
        if (opStart <= posTime && opEnd >= posTime) {
            posTime = opEnd;
        }
        
        answer = changeMinute(posTime);
        
        return answer;
    }
    public String changeMinute (int time) {
        String minute = String.valueOf(time / 60);
        
        int secondTime = time % 60;
        
        String second = String.valueOf(secondTime);
        
        minute = minute.length() == 1 ? "0"+minute : minute;
        second = second.length() == 1 ? "0"+second : second;
        return minute + ":" + second;
    }
    
    public int changeSecond(String time) {
        String[] times = time.split(":");
        int m = Integer.parseInt(times[0]) * 60;
        int s = Integer.parseInt(times[1]);
        
        return m + s;
    }
    
    public void move(String command) {
        if ("next".equals(command)) {
            posTime += 10;
            
            if (videoLen < posTime) {
                posTime = videoLen;
            }
        }
        else {
            posTime -= 10;
            if (posTime < 0) {
                posTime = 0;
            }
        }
    }
}
