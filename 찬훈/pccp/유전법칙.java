import java.util.*;

class Solution {
    String[] geneCase = {"RR", "Rr", "Rr", "rr"};

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];

            String result = getGene(n, p);

            answer[i] = result;
        }

        return answer;
    }

    private String getGene(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        String motherGene = getGene((n - 1), (p - 1) / 4 + 1);

        if (motherGene == "Rr") {
            int idx = (p + 3) % 4;

            return geneCase[idx];
        }

        return motherGene;
    }
}
