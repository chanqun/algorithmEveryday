import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    char[] arr;
    boolean[] visited;
        
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        arr = numbers.toCharArray();
                
        recursion("",0);
        
        answer = set.size();
        return answer;
    }
    
    public void recursion(String str, int idx){
        if(str != ""){
            int num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        if(idx==arr.length) return;
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            recursion(str+arr[i], idx+1);
            visited[i] = false;
        }
    }

    public boolean isPrime(int num){
        if(num==0||num==1) {
            return false;
        }

        for(int i=2; i*i<=num; i++){
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}

