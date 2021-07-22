fun solution(n: Long): IntArray {
    var answer = arrayListOf<Int>()

    n.toString().reversed().forEach {
        answer.add(it.toString().toInt())
    }

    return answer.toIntArray()
}