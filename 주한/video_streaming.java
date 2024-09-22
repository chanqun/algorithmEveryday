import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //각 시간들을 초로 변경
        int video_len_sec = changetoSec(video_len);
        int pos_sec = changetoSec(pos);
        int op_start_sec = changetoSec(op_start);
        int op_end_sec = changetoSec(op_end);
        //commands 전개
        for(int i = 0; i < commands.length; i++){ 
            if(pos_sec >= op_start_sec && pos_sec < op_end_sec){
                pos_sec = op_end_sec;
            }
            
            
            if(commands[i].equals("prev")){
                pos_sec -= 10;
                
                if(pos_sec < 0){
                    pos_sec = 0;
                }
                continue;
            }
            //next 를 만날 경우 = + 10
            if(commands[i].equals("next")){
                pos_sec += 10;
                
                if(video_len_sec - pos_sec < 10){
                    pos_sec = video_len_sec;
                }
                continue;
            }
        }
        
        if(pos_sec >= op_start_sec && pos_sec < op_end_sec){
            pos_sec = op_end_sec;
        }
        
        String answer = changetoTime(pos_sec);
        
        return answer;
    }
    
    private int changetoSec(String time){
        String[] minsec = time.split(":");
        int time_sec = 
            60*(Integer.parseInt(minsec[0])) + 
            Integer.parseInt(minsec[1]);
        
        return time_sec;
    }
    
    private String changetoTime(int time){
        StringBuilder sb = new StringBuilder();
        if(time/60 < 10){
            sb.append("0");
        }
        sb.append(time/60);
        sb.append(":");
        if(time%60 < 10){
            sb.append("0");
        }
        sb.append(time%60);
        
        return sb.toString();
    }
}
