import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int move: moves) {
            int doll = getAndRemove(board, move);
            
            if (doll == 0) {
                continue;
            }
            
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                answer += 2;
                    
                continue;
            }
            
            stack.push(doll);
        }
        
        return answer;
    }
    
    private int getAndRemove(int[][] board, int move) {
        int doll = 0;
        int N = board.length;
        int M = move - 1;
        
        for (int i = 0; i < N; i++) {
            int location = board[i][M];
            
            if (location != 0) {
                doll = location;
                board[i][M] = 0;
                
                break;
            }
        }
            
        return doll;
    }
}
