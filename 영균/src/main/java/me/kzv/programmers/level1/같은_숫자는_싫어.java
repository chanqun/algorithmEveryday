package me.kzv.programmers.level1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class 같은_숫자는_싫어 {

    public class Solution {
        public int[] solution(int[] arr) {
//            HashSet<Integer> set = new HashSet<>();
//            Arrays.stream(arr).forEach(it -> set.add(it));
//            int[] answer = new int[set.size()];
//            int index = 0;
////            answer = set.toArray(new Integer[set.size()]);
//            for (Integer integer : set) {
//                answer[index] = integer;
//                index++;
//            }
//
//            return answer;

            int[] answer;

            Stack<Integer> stack = new Stack<>();
            for (int i : arr) {
                stack.push(i);
                if (stack.size() >= 2) {
                    if (stack.get(stack.size() - 2).equals(stack.get(stack.size() - 1))) { // integer 자료형이므로 equals 사용 가능
                        stack.pop();
                    }
                }
            }

            answer = new int[stack.size()];
            int index = 0;

            for (Integer stackEl : stack) {
                answer[index++] = stackEl;
            }

            return answer;
        }


    }
}
/**
 *
 *  int : 자료형(primitive type)
 * 산술 연산 가능함
 * null 로 초기화 불가
 *
 * Integer : 래퍼 클래스 (Wrapper class)
 * 객체 간 비교하고 싶을 때 ex) equals()
 * 기본형 값이 아닌 객체로 저장하고 싶을 때
 * Unboxing 하지 않을 시 산술 연산 불가능함
 * null 값 처리 가능
 */