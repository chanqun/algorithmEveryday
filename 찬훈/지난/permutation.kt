val arrayList = arrayListOf("1", "2", "3", "4")
val visit = BooleanArray(4) { false }
val result = Array<String>(4) { "" }

fun main() {

    /**
     * ab
     * bc
     * cd
     * ac
     * ad
     */

    permutation(0)
}

fun combination(x: Int, index: Int) {
    if (x == 2) {
        for (i in 0 until 2) {
            print(result[i] + " ")
        }
        println()
        return
    } else {
        // 1 2 3 4
        for (i in index until 4) {
            if (!visit[i]) {
                visit[i] = true
                result[x] = arrayList[i]

                combination(x + 1, i)

                visit[i] = false
                result[x] = ""
            }
        }
    }
}

fun permutation(x: Int) {
    if (x == 2) {
        for (i in 0 until 2) {
            print(result[i] + " ")
        }
        println()
        return
    } else {
        // 1 2 3 4
        for (i in 0 until 4) {
            if (!visit[i]) {
                visit[i] = true
                result[x] = arrayList[i]

                permutation(x + 1)

                visit[i] = false
                result[x] = ""
            }
        }
    }

}
