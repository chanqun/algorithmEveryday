import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        var arrayList = new ArrayList<Integer>();
        
        arrayList.add(arr[0]);

        for (int i=1; i<arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                arrayList.add(arr[i]);
            }
        }

        return arrayList.stream().mapToInt(Integer :: intValue).toArray();
    }
}
