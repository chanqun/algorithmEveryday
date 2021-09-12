import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        var convertNum: String = n.toString(k)

        while (convertNum.contains("00")) {
            convertNum = convertNum.replace("00", "0")
        }

        val numList = convertNum.split("0")

        numList.forEach {
            if (it != "" && isPrime(it.toLong())) {
                answer++
            }
        }

        return answer
    }

    private fun isPrime(num: Long): Boolean {
        if (num <= 1) return false
        val end = sqrt(num.toDouble()).toInt()

        for (i in 2..end) {
            if (num % i == 0L) {
                return false
            }
        }

        return true
    }
}