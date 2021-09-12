import java.util.*

class Solution {
    var reportList = HashMap<String, HashSet<String>>()
    var reportCount = HashMap<String, HashSet<String>>()

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answerList = arrayListOf<Int>()

        id_list.forEach {
            reportList[it] = hashSetOf()
            reportCount[it] = hashSetOf()
        }

        report.forEach {
            val st = StringTokenizer(it)
            val reporter = st.nextToken()
            val reportee = st.nextToken()

            reportList[reporter]!!.add(reportee)
            reportCount[reportee]!!.add(reporter)
        }

        id_list.forEach {
            var count = 0
            reportList[it]!!.forEach {
                if (reportCount[it]!!.size >= k) {
                    count++
                }
            }

            answerList.add(count)
        }

        return answerList.toIntArray()
    }
}

