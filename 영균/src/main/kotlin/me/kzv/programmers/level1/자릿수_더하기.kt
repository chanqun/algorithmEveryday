package me.kzv.programmers.level1


fun main() {

    class Solution {
        fun solution(n: Int): Int {
            var answer = 0
            n.toString().forEach {
                answer += it.digitToInt() // char 는 toInt() 가 아니라 digitToInt() 를 써야함
            }

            return answer
        }
    }


}
