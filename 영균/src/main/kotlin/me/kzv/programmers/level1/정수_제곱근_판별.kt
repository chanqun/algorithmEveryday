package me.kzv.programmers.level1

fun main() {

    class Solution {
        fun solution(n: Long): Long {
            var num: Long = 0

            for (i in 1..n) {
                if (i * i == n) {
                    num = i
                    break
                }
            }

            return if (num > 0) (num + 1) * (num + 1) else -1
        }
    }

    class Solution2 {
        // 속도에서 거의 10 배 이상 차이난다.
        fun solution(n: Long): Long {
            val sqrt = Math.sqrt(n.toDouble())

            return if(sqrt % 1.0 == 0.0) { // 제곱근으로 만들었을 때 소숫점이 없다면 정수 제곱근 값을 가지는 것이다.
                Math.pow(sqrt + 1, 2.0).toLong() // 거듭제곱 함수 pow
            } else {
                -1L
            }
        }
    }
}