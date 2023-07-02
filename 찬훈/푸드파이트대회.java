class Solution {
    public String solution(int[] food) {
        StringBuffer sb = new StringBuffer();
        sb.append("0");
        
        for(int i=food.length - 1; i >= 1; i--) {
            int balance = food[i] / 2;
            
            for (int j=0; j<balance; j++) {
                sb.insert(0, i);
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}

