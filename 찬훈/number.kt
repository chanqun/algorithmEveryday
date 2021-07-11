class Solution {

    private val array = listOf(
        "zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"
    )

    fun solution(s: String): Int {
        var answer: Int = 0

        var str = s

        for (i in array.indices) {
            str = str.replace(array[i], i.toString())
        }

        answer = str.toInt()

        return answer
    }

}