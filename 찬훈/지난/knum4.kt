class Solution {
    var diff = 0
    var winArray = IntArray(11)

    fun solution(n: Int, info: IntArray): IntArray {
        val answer = intArrayOf(-1)
        diff = -1

        winArray = IntArray(11)

        val lion = IntArray(11)

        dfs(n, info, lion, 0, 0)

        return if (diff > 0) winArray else answer
    }

    fun dfs(n: Int, info: IntArray, lion: IntArray, idx: Int, cnt: Int) {
        if (cnt == n) {
            calculate(n, info, lion)
            return
        }
        if (idx == 11) {
            return
        }

        lion[idx]++
        dfs(n, info, lion, idx, cnt + 1)
        lion[idx]--
        dfs(n, info, lion, idx + 1, cnt)
    }

    fun calculate(n: Int, info: IntArray, lInfo: IntArray) {
        var appeachS = 0
        var lionS = 0

        for (i in 0..10) {
            if (info[i] == lInfo[i] && info[i] == 0) {
                continue
            } else if (info[i] >= lInfo[i]) {
                appeachS += 10 - i
            } else {
                lionS += 10 - i
            }
        }

        if (lionS > appeachS && lionS - appeachS >= diff) {
            var flag = true

            if (lionS - appeachS == diff) {
                for (i in 10 downTo 0) {
                    if (lInfo[i] > winArray[i]) {
                        break
                    } else if (lInfo[i] < winArray[i]) {
                        flag = false
                        break
                    }
                }
            }

            diff = lionS - appeachS

            if (flag) {
                for (i in 0..10) {
                    winArray[i] = lInfo[i]
                }
            }
        }
    }
}