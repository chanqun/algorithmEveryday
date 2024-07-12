import java.util.*;
import java.io.*;

class Main {
    private static int[] array;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        int len = nums.length;
        array = new int[len + 1];

        for (int i=0; i<len; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(array);

        dfs(0, 1, 0);

        for (int i=0; i<array.length; i++) {
            if (array[i] != 0) {
                sb.append(array[i]).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int cnt, int start, int sum) {
        if (cnt == 2) {
            for (int i=0; i<array.length; i++) {
                if (array[i] == sum) {
                    array[i] = 0;
                    break;
                }
            }

            return;
        }

        for (int i=start; i<array.length; i++) {
            if (array[i] != 0) {
                dfs (cnt+1, i+1, sum+array[i]);
            }
        }
    }
}

