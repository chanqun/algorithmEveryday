import java.util.*

class Solution {
    val map = HashMap<String, String>()

    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()

        val answerList = arrayListOf<String>()

        record.forEach {
            val st = StringTokenizer(it)

            val command = st.nextToken()

            if (command == "Enter") {
                val id = st.nextToken()
                val name = st.nextToken()

                map[id] = name
            } else if (command == "Leave") {
                val id = st.nextToken()

            } else if (command == "Change") {
                val id = st.nextToken()
                val name = st.nextToken()

                map[id] = name
            }
        }

        record.forEach {
            val st = StringTokenizer(it)

            val command = st.nextToken()

            if (command == "Enter") {
                val id = st.nextToken()
                val name = st.nextToken()

                answerList.add("${map[id]}님이 들어왔습니다.")
            } else if (command == "Leave") {
                val id = st.nextToken()

                answerList.add("${map[id]}님이 나갔습니다.")
            } else if (command == "Change") {
                val id = st.nextToken()
                val name = st.nextToken()

                map[id] = name
            }
        }

        answer = Array(answerList.size) { "" }

        for (i in 0 until answerList.size) {
            answer[i] = answerList[i]
        }

        return answer
    }
}