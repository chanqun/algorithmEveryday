package me.kzv.pccp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class 동영상재생기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"});
        solution.solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"});
    }

    static class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            LocalTime videoLen = getTime(video_len);
            LocalTime current = getTime(pos);
            LocalTime opStart = getTime(op_start);
            LocalTime opEnd = getTime(op_end);

            for(String command: commands) {
                if(!current.isAfter(opEnd) && !current.isBefore(opStart)) {
                    current = opEnd;
                }

                if("prev".equals(command)) {
                    current = prev(current, opStart, opEnd);
                }

                if("next".equals(command)) {
                    current = next(current, opStart, opEnd, videoLen);
                }

                if(!current.isAfter(opEnd) && !current.isBefore(opStart)) {
                    current = opEnd;
                }

                System.out.println(current);
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm:ss");
            String result = current.minusHours(1).format(dtf);
            System.out.println("result : " + result);
            return result;
        }

        private LocalTime prev(LocalTime current, LocalTime opStart, LocalTime opEnd) {
            current = current.minusSeconds(10);

            if(current.isBefore(LocalTime.of(1,0,0))) {
                return LocalTime.of(1, 0, 0);
            }

            return current;
        }

        private LocalTime next(LocalTime current, LocalTime opStart, LocalTime opEnd, LocalTime videoLen) {
            current = current.plusSeconds(10);

            if(current.isAfter(videoLen)) {
                return videoLen;
            }

            return current;
        }

        private LocalTime getTime(String source) {
            Integer[] time = Arrays.stream(source.split(":")).map(Integer::parseInt).toArray(Integer[]::new);
            return LocalTime.of(1, time[0], time[1]);
        }
    }
}
