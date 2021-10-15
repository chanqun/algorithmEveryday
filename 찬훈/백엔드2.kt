class Solution {
    val array = BooleanArray(31)

    fun solution(leave: Int, day: String, holidays: IntArray): Int {
        var answer: Int = -1

        makeCalendar(day, holidays)

        for (i in 1..30) {
            val result = calc(i, leave)

            answer = answer.coerceAtLeast(result)
        }

        return answer
    }

    private fun calc(startDay: Int, leave: Int): Int {
        var cLeave = leave
        var result = 0

        for (i in startDay..30) {
            if (!array[i]) {
                cLeave--
                if (cLeave < 0) {
                    break
                }
            }
            result++
        }

        return result
    }

    private fun makeCalendar(day: String, holidays: IntArray) {
        var days = day

        for (i in 1..30) {
            if (days == "SAT" || days == "SUN") {
                array[i] = true
            }

            days = getNextDay(days)
        }

        for (i in holidays) {
            array[i] = true
        }
    }

    private fun getNextDay(day: String): String {
        return when (day) {
            "MON" -> "TUE"
            "TUE" -> "WED"
            "WED" -> "THU"
            "THU" -> "FRI"
            "FRI" -> "SAT"
            "SAT" -> "SUN"
            "SUN" -> "MON"
            else -> "ERROR"
        }
    }
}
