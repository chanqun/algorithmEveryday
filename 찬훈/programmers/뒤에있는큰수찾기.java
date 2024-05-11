import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();

        for (int i = size - 1; i >= 0; i--) {
            int number = numbers[i];

            while (!stack.isEmpty() && number >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }

            stack.push(number);
        }

        return answer;
    }
}
