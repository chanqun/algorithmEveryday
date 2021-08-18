class New {
    fun solution(numOfStairs: Int): Long {
        var answer: Long = 0

        var array = LongArray(71)

        array[1] = 1
        array[2] = 2
        array[3] = 4
        array[4] = 7

        for (i in 5..numOfStairs) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1]
        }

        answer = array[numOfStairs]

        return answer
    }
}