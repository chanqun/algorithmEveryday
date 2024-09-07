package me.kzv.programmers.level1;


import java.util.ArrayList;
import java.util.Arrays;


public class 제일_작은_수_제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            if (arr.length == 1) return new int[]{-1};
            else {
                int min = findMin(arr);
                ArrayList<Integer> list = new ArrayList<>();
                for (int i : arr) {
                    if (i != min) list.add(i);
                }

                return list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
            }
        }

        private int findMin(int[] arr) {
            int min = Integer.MAX_VALUE;
            for (int i : arr) {
                if (i < min) min = i;
            }
            return min;
        }


        // 더 효율적으로 스트림 이용시
        public int[] solution2(int[] arr) {
            if (arr.length <= 1) return new int[]{ -1 };
            int min = Arrays.stream(arr).min().getAsInt();
            return Arrays.stream(arr).filter(i -> i != min).toArray();
        }

        // 최종?
        public int[] solution3(int[] arr) {
            if (arr.length <= 1) return new int[]{ -1 };
            int min = findMin(arr);
            return Arrays.stream(arr).filter(i -> i != min).toArray();
        }
    }
}
