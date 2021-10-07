class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = arrayListOf<Int>()
        var count = left

        var start = left / n
        var start2 = left % n

        for (i in start.toInt() until n) {
            var temp = 0

            for (j in 0 until n) {
                if (i == start.toInt() && j < start2.toInt()) {
                    continue
                }

                temp = if (i < j) {
                    j + 1
                } else {
                    i + 1
                }

                if (count in left..right) {
                    answer.add(temp)
                }

                count++

                if (count > right) {
                    break
                }
            }
        }

        return answer.toIntArray()
    }
}