import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""

        var tempId = new_id

        tempId = check1(tempId)
        tempId = check2(tempId)
        tempId = check3(tempId)
        tempId = check4(tempId)
        tempId = check5(tempId)
        tempId = check6(tempId)
        tempId = check7(tempId)

        answer = tempId
        return answer
    }

    private fun check7(tempId: String): String {
        var tempId2 = tempId

        while (tempId2.length <= 2) {
            tempId2 += tempId2[tempId2.lastIndex]
        }

        return tempId2
    }

    private fun check6(tempId: String): String {
        var tempId2 = tempId

        if (tempId2.length >= 16) {
            tempId2 = tempId2.substring(0, 15)
        }

        tempId2 = check4(tempId2)

        return tempId2
    }

    private fun check5(tempId: String): String {
        if (tempId.isEmpty()) {
            return "a"
        }

        return tempId
    }

    private fun check4(tempId: String): String {
        var tempId2 = tempId

        if (tempId2.isNotEmpty() && tempId2[0] == '.') {
            tempId2 = tempId2.substring(1)
        }

        if (tempId2.isNotEmpty() && tempId2[tempId2.lastIndex] == '.') {
            tempId2 = tempId2.substring(0, tempId2.lastIndex)
        }

        return tempId2
    }

    private fun check3(tempId: String): String {
        var tempId2 = tempId

        while (tempId2.contains("..")) {
            tempId2 = tempId2.replace("..", ".")
        }

        return tempId2
    }

    private fun check2(tempId: String): String {
        return tempId.filter {
            (it == '_' || it == '-' || it == '.' || it.isLetterOrDigit())
        }
    }

    private fun check1(tempId: String): String {
        return tempId.toLowerCase()
    }
}

