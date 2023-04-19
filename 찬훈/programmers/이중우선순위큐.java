import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i =0; i< operations.length; i++) {
            String[] operation = operations[i].split(" ");
            String command = operation[0];
            int num = Integer.parseInt(operation[1]);
            
            if (command.equals("I")) {
                p1.add(num);
                p2.add(num);
            } else {
                if (num == 1 && !p2.isEmpty()) {
                    int temp = p2.poll();
                    p1.remove(temp);
                } else if (num == -1 && !p1.isEmpty()) {
                    int temp = p1.poll();
                    p2.remove(temp);
                }
            }
        }
        
        if (p1.isEmpty()) {
            return new int[2];
        }

        return new int[] {p2.poll(), p1.poll()};
    }
}

