package level1

import kotlin.math.sqrt

fun main() {
    val number = 10

    print(solution(number, 3, 2))
}

fun solution(number: Int, limit: Int, power: Int): Int {
    var answer: Int = 0
    var overpower = mutableListOf<Int>()

    var countList = (1..number).map {
        countDivider(it)
    }.toList()

    countList.forEach { count ->
        if (count > limit) {
            overpower.add(power)
        } else {
            overpower.add(count)
        }
    }

    for (i in overpower) {
        answer += i
    }

    return answer
}

private fun countDivider(number: Int): Int {
    var count = 0
    val temp = sqrt(number.toDouble()).toInt() // sqrt(k)는, f(x) = x^2 - k = 0의 근

    for (l in 1..temp) {
        if (number % l == 0) {
            if (l * l == number) {
                count++
            } else {
                count += 2
            }
        }
    }

    return count
}
