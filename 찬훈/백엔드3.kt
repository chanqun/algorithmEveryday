import java.util.*

class Solution {
    private val array = Array(6) { IntArray(6) }
    val dy = intArrayOf(-1, 0, 1, 0)
    val dx = intArrayOf(0, 1, 0, -1)

    fun solution(macaron: Array<IntArray>): Array<String> {
        var answer = Array(6) { "" }

        macaron.forEach {
            val position = it[0] - 1
            val color = it[1]

            down(position, color)
            destroy()
        }

        for (i in 0..5) {
            var result = ""

            for(j in 0..5) {
                result += array[i][j]
            }

            answer[i] = result
        }

        return answer
    }

    private fun destroy() {
        var keepGoing = 1

        while (keepGoing > 0) {
            keepGoing = 0
            val check = Array(6) { BooleanArray(6) }

            for (i in 0..5) {
                for (j in 0..5) {
                    if (array[i][j] != 0 && !check[i][j]) {
                        keepGoing += bfs(i, j, check)
                    }
                }
            }

            clean()
        }
    }

    private fun clean() {
        for (j in 0..5) {
            var idx = 5
            for (i in 5 downTo 0) {
                if (array[i][j] != 0) {
                    var temp = array[i][j]
                    array[i][j] = 0
                    array[idx][j] = temp
                    idx--
                }
            }
        }
    }

    private fun bfs(i: Int, j: Int, check: Array<BooleanArray>): Int {
        val checkList = arrayListOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        queue.add(Pair(i, j))
        check[i][j] = true
        checkList.add(Pair(i, j))

        while (!queue.isEmpty()) {
            val (y, x) = queue.poll()

            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny < 0 || nx < 0 || ny >= 6 || nx >= 6 || check[ny][nx] || array[ny][nx] != array[y][x]) {
                    continue
                }

                queue.add(Pair(ny, nx))
                check[ny][nx] = true
                checkList.add(Pair(ny, nx))
            }
        }

        if (checkList.size >= 3) {
            checkList.forEach {
                val n = it.first
                val m = it.second
                array[n][m] = 0
            }

            return 1
        }

        return 0
    }

    private fun down(position: Int, color: Int) {
        for (i in 0 until 5) {
            if (array[i + 1][position] != 0) {
                array[i][position] = color
                return
            }
        }

        array[5][position] = color
    }
}