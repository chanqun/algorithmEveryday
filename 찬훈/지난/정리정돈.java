import java.util.*;
import java.io.*;

class Main {
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        String[] l1 = reader.readLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int m = Integer.parseInt(l1[1]);

        arr = new int[n];

        String[] l2 = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(l2[i]);
        }

        for (int t = 0; t < m; t++) {
            String[] l3 = reader.readLine().split(" ");

            int i = Integer.parseInt(l3[0]) - 1;
            int j = Integer.parseInt(l3[1]) - 1;
            int k = Integer.parseInt(l3[2]) - 1;

            int[] subArray = Arrays.copyOfRange(arr, i, j + 1);
            Arrays.sort(subArray);
            int kthElement = subArray[k];

            System.out.println(kthElement);
        }
    }
}
