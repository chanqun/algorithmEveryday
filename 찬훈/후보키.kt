import java.lang.StringBuilder

class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        var answer = 0

        val arrayList = ArrayList<Int>()
        val n = relation.size
        val m = relation[0].size

        for (i in 1 until (1.shl(m))) {
            val set = hashSetOf<String>()

            for (j in 0 until n) {
                val sb = StringBuilder()

                for (k in 0 until m) {
                    //정수 k가 비트마스크 i에 포함
                    if (i and (1.shl(k)) > 0) {
                        sb.append(relation[j][k])
                    }
                }

                set.add(sb.toString())
            }

            if (set.size == n && check(arrayList, i)) {
                arrayList.add(i)
            }
        }

        answer = arrayList.size
        return answer
    }

    // 최소성 검사
    private fun check(ans: ArrayList<Int>, now: Int): Boolean {
        for (i in 0 until ans.size) {
            if (ans[i].and(now) == ans[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val relation = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2")
    )

    val solution = Solution()

    println(solution.solution(relation))
}