import java.util.*
import kotlin.math.ceil

class Solution {
    var map = HashMap<String, Int>()
    var mapTime = HashMap<String, Int>()

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answerList = arrayListOf<Pair<String, Int>>()

        records.forEach {
            val st = StringTokenizer(it)

            val time = convertTime(st.nextToken())
            val carNumber = st.nextToken()
            val command = st.nextToken()

            if (command == "IN") {
                map[carNumber] = time
            } else {
                val total = time - map[carNumber]!!
                map.remove(carNumber)

                mapTime[carNumber] = (mapTime[carNumber] ?: 0) + total
            }
        }

        map.keys.forEach {
            mapTime[it] = (mapTime[it] ?: 0) + (23 * 60 + 59 - map[it]!!)
        }

        mapTime.keys.forEach {
            val result = calculate(mapTime[it]!!, fees)
            answerList.add(Pair(it, result))
        }

        answerList.sortBy { it.first }

        return answerList.map {
            it.second
        }.toIntArray()
    }

    private fun calculate(time: Int, fees: IntArray): Int {
        var result = 0

        if (time <= fees[0]) {
            result = fees[1]
        } else {
            result = fees[1]
            result += ceil((time - fees[0])/fees[2].toDouble()).toInt() * fees[3]
        }

        return result
    }

    private fun convertTime(time: String): Int {
        val split = time.split(":")

        val calTime = split[0].toInt() * 60 + split[1].toInt()

        return calTime
    }
}
