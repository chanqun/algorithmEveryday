class Solution {
    fun solution(s: String): String {
        var answer = ""

        var index = 0

        s.forEach {
            if (it.isLetter()) {

                if (index % 2 == 0) {
                    answer += it.toUpperCase()
                } else {
                    answer += it.toLowerCase()
                }

            } else {
                answer += " "
                index = -1
            }

            index++
        }
        return answer
    }
}