import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visit = new boolean[1001];
    
	public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int listSize = Integer.parseInt(st.nextToken());
        int edgeLen = Integer.parseInt(st.nextToken());
        
        int startNum = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= listSize; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edgeLen; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            list.get(in).add(out);
            list.get(out).add(in);
        }
        
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        
        visit[startNum] = true;
        dfs(startNum);
        System.out.println();
        bfs(startNum);
	}
    
    static void dfs (int num) {
        if (visit[num]) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < list.get(num).size(); i++) {
            int input = list.get(num).get(i);
            if (!visit[input]) {
                visit[input] = true;
                dfs(input);
            }
        }
    }
    
    static void bfs (int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
        visit[num] = true;
        
        while(!q.isEmpty()) {
            int getNum = q.poll();
            System.out.print(getNum + " ");
            for (int i = 0; i < list.get(getNum).size(); i++) {
                int input = list.get(getNum).get(i);
                if (!visit[input]) {
                    visit[input] = true;
                    q.add(input);
                }
            }
        }
    }
}