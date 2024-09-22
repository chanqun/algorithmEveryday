import java.util.*;

class Solution {
    private int videoLen;
    private int posInt;
    private int opStart;
    private int opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        videoLen = changeTimeStringToInt(video_len);
        posInt = changeTimeStringToInt(pos);
        opStart = changeTimeStringToInt(op_start);
        opEnd = changeTimeStringToInt(op_end);
        
        for(String command: commands) {
            doCommand(command);
        }
        
        answer = makeIntToAnswer(posInt);

        return answer;
    }
    
    private int changeTimeStringToInt(String time) {
        String[] timeArray = time.split(":");
        
        return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
    }
    
    private void doCommand(String command) {
        if (posInt >= opStart && posInt <= opEnd) {
            posInt = opEnd;
        }
        
        if (command.equals("next")) {
            int temp = posInt + 10;
            
            if (temp > videoLen) {
                posInt = videoLen;
            } else {
                posInt = temp;                
            }
        } else if (command.equals("prev")) {
            int temp = posInt - 10;
            
            if (temp < 0) {
                posInt = 0;
            } else {
                posInt = temp;                
            }
        }
        
        if (posInt >= opStart && posInt <= opEnd) {
            posInt = opEnd;
        }
    }
    
    private String makeIntToAnswer(int num) {
        int hour = num / 60;
        int min = num % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if (hour < 10) {
            sb.append("0");
        }
        
        sb.append(hour + ":");
        
        if (min < 10) {
            sb.append("0");
        }
        
        sb.append(min);
        
        return sb.toString();
    }
}
