import java.util.*;

class Solution {
    int[] person1 = {1,2,3,4,5};
    int[] person2 = {2,1,2,3,2,4,2,5};
    int[] person3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int correct1 = 0;
        int correct2 = 0;
        int correct3 = 0;
        
        for (int i=0; i<answers.length; i++) {
            int nowAnswer = answers[i];
            
            if (person1[i % person1.length] == nowAnswer) {
                correct1++;
            }
            
            if (person2[i % person2.length] == nowAnswer) {
                correct2++;
            }
            
            if (person3[i % person3.length] == nowAnswer) {
                correct3++;
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(1, correct1));
        
        if (q.peek().count < correct2) {
            while(!q.isEmpty()) {
                q.poll();
            }
            q.add(new Pair(2, correct2));
        } else if (q.peek().count == correct2) {
            q.add(new Pair(2, correct2));
        }
        
        if (q.peek().count < correct3) {
            while(!q.isEmpty()) {
                q.poll();
            }
            q.add(new Pair(3, correct3));
        } else if (q.peek().count == correct3) {
            q.add(new Pair(3, correct3));
        }
        
        answer = new int[q.size()];
        int count = 0;
        while(!q.isEmpty()) {
            answer[count] = q.poll().idx;
            count++;
        }
        
        return answer;
    }
}

class Pair {
    int idx;
    int count;
    
    Pair(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }
}
