package me.kzv.programmers.level1

fun main() {

    class Solution {
        fun solution(num: Int): String {
            var answer = ""
            answer = when {
                (num % 2 == 0) -> "Even"
                else -> "Odd"
            }

            return answer
        }
    }

}