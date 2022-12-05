class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()

        var array = Array(N) { Result(it + 1, 0, 0, 0.0) }

        stages.forEach {
            for (i in 0 until it) {
                if (i == N) {
                    continue
                }

                array[i].total++

                if (i == it - 1) {
                    array[i].fail++
                }
            }
        }

        array.forEach {
            if (it.total != 0) {
                it.rate = it.fail.toDouble() / it.total
            }
        }

        array.sortBy { -it.rate }

        answer = array.map {
            it.index
        }.toIntArray()

        return answer
    }
}

data class Result(
    var index: Int,
    var fail: Int,
    var total: Int,
    var rate: Double
)