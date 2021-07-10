import java.lang.Math.abs

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""

    var leftHandLocation = Pair(0, 3) //x, y
    var rightHandLocation = Pair(2, 3)

    for (i in numbers) {

        if (i == 1 || i == 4 || i == 7) {
            answer += "L"

            when (i) {
                1 -> leftHandLocation = Pair(0, 0)
                4 -> leftHandLocation = Pair(0, 1)
                7 -> leftHandLocation = Pair(0, 2)
            }

        } else if (i == 3 || i == 6 || i == 9) {
            answer += "R"

            when (i) {
                3 -> rightHandLocation = Pair(2, 0)
                6 -> rightHandLocation = Pair(2, 1)
                9 -> rightHandLocation = Pair(2, 2)
            }
        } else {
            if (i == 2) {
                val lDistance = abs(1 - leftHandLocation.first) + abs(0 - leftHandLocation.second)
                val rDistance = abs(1 - rightHandLocation.first) + abs(0 - rightHandLocation.second)

                if (lDistance < rDistance) {
                    answer += "L"
                    leftHandLocation = Pair(1, 0)
                } else if (lDistance > rDistance) {
                    answer += "R"
                    rightHandLocation = Pair(1, 0)
                } else {
                    if (hand == "left") {
                        answer += "L"
                        leftHandLocation = Pair(1, 0)
                    } else {
                        answer += "R"
                        rightHandLocation = Pair(1, 0)
                    }
                }
            } else if (i == 5) {
                val lDistance = abs(1 - leftHandLocation.first) + abs(1 - leftHandLocation.second)
                val rDistance = abs(1 - rightHandLocation.first) + abs(1 - rightHandLocation.second)

                if (lDistance < rDistance) {
                    answer += "L"
                    leftHandLocation = Pair(1, 1)
                } else if (lDistance > rDistance) {
                    answer += "R"
                    rightHandLocation = Pair(1, 1)
                } else {
                    if (hand == "left") {
                        answer += "L"
                        leftHandLocation = Pair(1, 1)
                    } else {
                        answer += "R"
                        rightHandLocation = Pair(1, 1)
                    }
                }
            } else if (i == 8) {
                val lDistance = abs(1 - leftHandLocation.first) + abs(2 - leftHandLocation.second)
                val rDistance = abs(1 - rightHandLocation.first) + abs(2 - rightHandLocation.second)

                if (lDistance < rDistance) {
                    answer += "L"
                    leftHandLocation = Pair(1, 2)
                } else if (lDistance > rDistance) {
                    answer += "R"
                    rightHandLocation = Pair(1, 2)
                } else {
                    if (hand == "left") {
                        answer += "L"
                        leftHandLocation = Pair(1, 2)
                    } else {
                        answer += "R"
                        rightHandLocation = Pair(1, 2)
                    }
                }
            } else {
                val lDistance = abs(1 - leftHandLocation.first) + abs(3 - leftHandLocation.second)
                val rDistance = abs(1 - rightHandLocation.first) + abs(3 - rightHandLocation.second)

                if (lDistance < rDistance) {
                    answer += "L"
                    leftHandLocation = Pair(1, 3)
                } else if (lDistance > rDistance) {
                    answer += "R"
                    rightHandLocation = Pair(1, 3)
                } else {
                    if (hand == "left") {
                        answer += "L"
                        leftHandLocation = Pair(1, 3)
                    } else {
                        answer += "R"
                        rightHandLocation = Pair(1, 3)
                    }
                }
            }
        }
    }

    return answer
}
