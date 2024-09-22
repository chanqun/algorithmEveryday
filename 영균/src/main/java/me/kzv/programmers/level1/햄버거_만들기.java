package me.kzv.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/133502

public class 햄버거_만들기 {
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            java.util.Stack<Integer> stack = new java.util.Stack<>();
            for (int i : ingredient) {
                stack.push(i);
                if (stack.size() >= 4) {
                    // 문자열로 만들어 1231 비교하는 것보다 그냥 하나씩 비교하는게 훨씬 더 빠름
                    if(stack.get(stack.size()-4) == 1
                            && stack.get(stack.size()-3) == 2
                            && stack.get(stack.size()-2) == 3
                            && stack.get(stack.size()-1) == 1) {

                        answer++;
                        stack.pop(); stack.pop(); stack.pop(); stack.pop();
                    }
                }
            }

            return answer;
        }
    }
}
