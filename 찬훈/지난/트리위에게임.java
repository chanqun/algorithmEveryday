import java.util.*;

class Main {
    private static List<Integer>[] list;
    private static int[] dp;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList[n+1];
        dp = new int[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            list[u].add(v);
            list[v].add(u);
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            stack.push(node);

            for (int child: list[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        Arrays.fill(visited, false);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;
            boolean isLeaf = true;

            int minValue = Integer.MAX_VALUE;

            for (int child: list[node]) {
                if (visited[child]) {
                    isLeaf = false;
                    minValue = Math.min(minValue, dp[child]);
                }
            }

            if (isLeaf) {
                dp[node] = node;
            } else {
                dp[node] = node - minValue;
            }
        }

        for (int i=1; i<=n; i++) {
            if (dp[i] >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}


