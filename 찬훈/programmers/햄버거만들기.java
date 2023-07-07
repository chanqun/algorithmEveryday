import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    int answer = 0;

    public int solution(int[] ingredient) {
        for (int nowIngredient: ingredient) {
            stack.push(nowIngredient);
            
            checkBurger();
        }
        
        return answer;
    }
    
    private void checkBurger() {
        if (stack.size() >= 4) {
            int a = stack.pop();
            int b = stack.pop();
            int c = stack.pop();
            int d = stack.pop();

            if (a==1 && b==3 && c==2 && d==1) {
                answer++;
            } else {
                stack.push(d);
                stack.push(c);
                stack.push(b);
                stack.push(a);
            }
        }
    }
}
