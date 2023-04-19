import java.util.*;

class Solution {
    long callTime = 0;
    int runningTime = 0;
    long totalRunningTime = 0;
    long blankTime = 0;

    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        PriorityQueue<Os> osQ = new PriorityQueue<>();

        for (int i = 0; i < program.length; i++) {
            osQ.add(new Os(program[i][0], program[i][1], program[i][2]));
        }

        PriorityQueue<WaitingOs> waitingOsQ = new PriorityQueue<>();

        Os tempOs = null;
        WaitingOs tempWaitingOs = null;

        Os os = osQ.poll();

        callTime = os.callTime;
        runningTime = os.runningTime;
        blankTime = callTime;

        totalRunningTime += blankTime;
        totalRunningTime += runningTime;

        while (!osQ.isEmpty() || !waitingOsQ.isEmpty()) {
            if (!osQ.isEmpty()) {
                if (totalRunningTime >= osQ.peek().callTime) {
                    tempOs = osQ.poll();
                    waitingOsQ.add(new WaitingOs(tempOs.grade, tempOs.callTime, tempOs.runningTime));
                    continue;
                }

                if (waitingOsQ.isEmpty()) {
                    tempOs = osQ.poll();

                    blankTime = tempOs.callTime - totalRunningTime;
                    totalRunningTime += (blankTime + tempOs.runningTime);
                }
            }

            if (!waitingOsQ.isEmpty()) {
                tempWaitingOs = waitingOsQ.poll();
                answer[tempWaitingOs.grade] += (totalRunningTime - tempWaitingOs.callTime);
                totalRunningTime += tempWaitingOs.runningTime;
            }
        }

        answer[0] = totalRunningTime;

        return answer;
    }
}

class Os implements Comparable<Os> {
    int grade = 0;
    long callTime = 0;
    int runningTime = 0;

    public Os(int grade, long callTime, int runningTime) {
        this.grade = grade;
        this.callTime = callTime;
        this.runningTime = runningTime;
    }

    @Override
    public int compareTo(Os other) {
        if (this.callTime == other.callTime) {
            if (this.grade >= other.grade) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (this.callTime >= other.callTime) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

class WaitingOs implements Comparable<WaitingOs> {
    int grade = 0;
    long callTime = 0;
    int runningTime = 0;

    public WaitingOs(int grade, long callTime, int runningTime) {
        this.grade = grade;
        this.callTime = callTime;
        this.runningTime = runningTime;
    }

    @Override
    public int compareTo(WaitingOs other) {
        if (this.grade == other.grade) {
            if (this.callTime >= other.callTime) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (this.grade >= other.grade) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}