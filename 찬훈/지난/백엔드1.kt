class Solution {
    val array = BooleanArray(1_000_000)

    fun solution(registered_list: Array<String>, new_id: String): String {
        var answer = ""

        var (S, N) = splitNewId(new_id)

        if (N == 0) {
            if (!registered_list.contains(S)) {
                return S
            }
            N++
        }

        val newRegisteredList = registered_list.filter { it.contains(S) }

        newRegisteredList.forEach {
            val (s1, n1) = splitNewId(it)
            array[n1] = true
        }

        for (i in N until 1_000_000) {
            if (!array[i]) {
                return S + i
            }
        }

        return answer
    }

    private fun splitNewId(newId: String): Pair<String, Int> {
        var index = 0

        for (i in 0..newId.lastIndex) {
            if (newId[i].isDigit()) {
                index = i
                break
            }
        }

        if (index == 0) {
            index = newId.lastIndex + 1
        }

        val S = newId.substring(0, index)
        var N = newId.substring(index)

        if (N == "") {
            N = "0"
        }

        var intN = N.toInt()

        return Pair(S, intN)
    }
}