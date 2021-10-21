import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit = new boolean[50];
    static int k;
    static List<Integer> list;
    
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        
        while (sc.hasNextInt()) {
            st = new StringTokenizer(sc.nextLine());
            
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            
            list = new ArrayList<>();
            
            while (st.hasMoreTokens()) {
            	list.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(list);
            
            combination (0, 0);
            
            System.out.println();
            Arrays.fill(visit, false);
        }
    }
    
    static void combination (int start, int count) {
        if (count == 6) {
            for (int i = 1; i < visit.length; i++) {
                if (visit[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = start; i < list.size(); i++) {
            if (visit[list.get(i)]) continue;
            visit[list.get(i)] = true;
            combination (i + 1, count + 1);
            visit[list.get(i)] = false;
        }
    }
}