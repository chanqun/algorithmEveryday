import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        String nextNumber = getNextNumber(str);

        System.out.println(nextNumber);
    }

    public static String getNextNumber(String str) {
        char[] digits = str.toCharArray();
        int n = digits.length;

        int i = n - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "No higher number possible";
        }

        int j = n - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        swap(digits, i, j);

        reverse(digits, i + 1, n - 1);

        return new String(digits);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
