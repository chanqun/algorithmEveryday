import java.util.*

val map = HashMap<Data, ArrayList<Int>>()

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray
        var tempAnswer = arrayListOf<Int>()

        info.forEach {
            val st = StringTokenizer(it)

            val language = st.nextToken()
            val job = st.nextToken()
            val career = st.nextToken()
            val soulFood = st.nextToken()
            val score = st.nextToken().toInt()

            for (i in arrayListOf("-", language)) {
                for (j in arrayListOf("-", job)) {
                    for (k in arrayListOf("-", career)) {
                        for (l in arrayListOf("-", soulFood)) {
                            val data = Data(i, j, k, l)

                            if (map.containsKey(data)) {
                                val arrayList = map[data]
                                arrayList!!.add(score)

                                map[data] = arrayList
                            } else {
                                map[data] = arrayListOf(score)
                            }
                        }
                    }
                }
            }
        }

        for (i in map.keys) {
            val arrayList = map[i]
            arrayList?.sort()
        }

        query.forEach {
            val st = it.split(" ")
            val language = st[0]
            val job = st[2]
            val career = st[4]
            val soulFood = st[6]
            val score = st[7].toInt()

            val checkArrayList = map[Data(language, job, career, soulFood)]

            if (checkArrayList != null) {
                var start = 0
                var end = checkArrayList!!.lastIndex

                while (start <= end) {
                    var mid = (start + end) / 2
                    if (checkArrayList[mid] < score) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
                tempAnswer.add(checkArrayList.size - start)
            } else {
                tempAnswer.add(0)
            }
        }

        answer = tempAnswer.toIntArray()
        return answer
    }
}

data class Data(
    val language: String,
    val job: String,
    val career: String,
    val soulFood: String
)

fun main() {
    val solution = Solution()
    val info = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    )
    val query = arrayOf(
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )
    solution.solution(info, query)
}


