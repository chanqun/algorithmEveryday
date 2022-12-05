class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0

        var temp = n - 1

        for (i in 2..1_000_000) {
            if (temp % i == 0) {
                answer = i
                break
            }
        }

        return answer
    }
}