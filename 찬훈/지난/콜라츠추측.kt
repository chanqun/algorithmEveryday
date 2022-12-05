class Solution {
    fun solution(num: Int): Int {
        var number = num.toLong()

        if (number == 1L) {
            return 0
        }

        for (index in 1..500) {
            if (number % 2 == 0L) {
                number /= 2
            } else {
                number = number * 3 + 1
            }

            if (number == 1L) {
                return index
            }
        }

        return -1
    }
}