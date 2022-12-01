package level1

fun main() {

    class Solution {
        fun solution(arr: IntArray): Double {
            var answer = 0.0
            var sum = 0.0

            arr.toList().forEach {
                sum += it
            }

            answer = sum / arr.size.toDouble()

            return answer
        }
    }

}