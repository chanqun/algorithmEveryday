package level1

fun main() {
    class Solution {
        fun solution(n: Long): IntArray {
            var answer = intArrayOf()
            answer = n.toString().reversed().map { it.toString().toInt() }.toIntArray()

            return answer
        }

        fun solution2(n: Long): IntArray {
            var num = n
            var answer = intArrayOf()

            while (num > 0) {
                answer += (num % 10).toInt()
                num = num / 10
            }

            return answer
        }


    }


    fun test(){
        var array = intArrayOf()

        array += 12
        array += 122
        array += 123
        array += 124

        array.forEach { println(it) }
    }
}