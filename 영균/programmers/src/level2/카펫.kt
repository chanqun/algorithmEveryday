package level2

import kotlin.math.sqrt

/**
brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
 */

fun solution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    val carpet = brown + yellow

    for (i in carpet / 2 downTo 0 step (1)) {
        if (carpet % i == 0) {
            val width = i
            val height = carpet / i

            if ((width - 2) * (height - 2) == yellow) {
                answer = intArrayOf(width, height)
                break
            }
        }
    }

    return answer
}


fun main() {

    val sol = solution(14, 4)
    println(sol)
}

// 12, 4  14, 4
// 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.


/**
 *         y 3
b 12
yb 15
 */

fun solution1(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    val sum = brown + yellow

    for (i in 1..sum) {
//        if (sum % i == 0)
    }

    var width: Int = 0
    var height: Int = 0

//    for (l in 3..temp) {
//        if (sum % l == 0) {
//            width = if (l * l == sum) {
//                l
//            } else {
//                sum / l
//            }
//        }
//    }

    height = sum / width
    answer = intArrayOf(width, height)

    return answer
}


fun solution2(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()

    var list = mutableListOf<Int>()
    val sum = brown + yellow

    for (i in 3..sum) {
        if (sum % i == 0) list.add(i)
    }


    list.forEach {
        val row = it + 2
        var col = yellow / it + 2

        if (row * col == sum) {
            answer = intArrayOf(row, col)
        }
    }

    return answer
}

fun solution3(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()

    var list = mutableListOf<Int>()
    val sum = brown + yellow

    for (i in 3..sum) {
        if (sum % i == 0) list.add(i)
    }


    list.forEach {
        val row = it
        var col = yellow / it

        if ((row + 2) * (col + 2) == sum) {
            answer = intArrayOf(row, col)
        }
    }

    return answer
}


