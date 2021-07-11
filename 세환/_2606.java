package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> node = new ArrayList<>();
		StringTokenizer st;

		int nodeCount = Integer.parseInt(br.readLine());
		for (int i = 0; i <= nodeCount; i++) {
			node.add(new ArrayList<>());
		}

		int line = Integer.parseInt(br.readLine());
		for (int i = 0; i < line; i++) {
			String val = br.readLine();
			st = new StringTokenizer(val);
			int get = Integer.parseInt(st.nextToken());
			int add = Integer.parseInt(st.nextToken());
			node.get(get).add(add);
			node.get(add).add(get);
		}

		_2606.DFS(node);
	}

	public static void DFS(List<List<Integer>> node) {
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		int check[] = new int[node.size() + 1];

		stack.add(1);
		check[1]++;
		while (!stack.isEmpty()) {
			int num = stack.pop();

			for (int i = 0; i < node.get(num).size(); i++) {
				int val = node.get(num).get(i);
				if (check[val] == 0) {
					stack.add(val);
					count++;
					check[val]++;
				}
			}
		}

		System.out.println(count );
	}
}
