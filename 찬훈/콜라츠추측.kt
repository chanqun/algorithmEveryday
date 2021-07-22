class Solution {
    fun solution(num: Int): Int {
        var number = num

        if (number == 1) {
            return 0
        }

        for (index in 1..500) {
            if (number % 2 == 0) {
                number /= 2
            } else if(number % 2 == 1){
                number = number * 3 + 1
            }

            if (number == 1) {
                return index
            }
        }

        return -1
    }
}