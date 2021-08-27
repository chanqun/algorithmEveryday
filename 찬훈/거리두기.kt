import java.util.*

class Solution {
    val dy = arrayOf(0, 1, 0, -1)
    val dx = arrayOf(-1, 0, 1, 0)

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size) { 0 }

        for (i in places.indices) {
            val map = places[i]

            answer[i] = 1

            loop@ for (y in 0 until 5) {
                for (x in 0 until 5) {
                    if (map[y][x] == 'P') {
                        println("$y / $x")
                        val result = bfs(map, y, x)

                        if (!result) {
                            answer[i] = 0
                            break@loop
                        }
                    }
                }
            }

            println()
        }

        return answer
    }

    private fun bfs(map: Array<String>, r: Int, c: Int): Boolean {
        val visit = Array(5) { BooleanArray(5) }
        val queue: Queue<Pos> = LinkedList()

        visit[r][c] = true
        queue.add(Pos(r, c, 0))

        while (!queue.isEmpty()) {
            val (y, x, distance) = queue.poll()

            if (distance > 0 && map[y][x] == 'P') {
                return false
            }

            for (i in 0 until 4) {
                val dy = y + dy[i]
                val dx = x + dx[i]

                if (dy < 0 || dx < 0 || dy >= 5 || dx >= 5 || map[dy][dx] == 'X' || visit[dy][dx]) continue
                if (distance + 1 > 2) continue

                visit[dy][dx] = true
                queue.add(Pos(dy, dx, distance + 1))
            }
        }

        return true
    }
}

data class Pos(
    val y: Int,
    val x: Int,
    val distance: Int
)