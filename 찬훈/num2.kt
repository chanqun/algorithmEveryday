class Solution {
    //왼 0 아래 1 오 2 위 3
    val dy = arrayOf(0, 1, 0, -1)
    val dx = arrayOf(-1, 0, 1, 0)
    var row = 0
    var column = 0
    val set = hashSetOf<Pos>()

    fun solution(grid: Array<String>): IntArray {
        var answerList = arrayListOf<Int>()

        row = grid.size
        column = grid[0].length

        for (i in 0 until row) {
            for (j in 0 until column) {
                for (k in 0 until 4) {
                    val result = going(i, j, k, grid)

                    if(result != 0){
                        answerList.add(result)
                    }
                }
            }
        }

        answerList.sort()

        return answerList.toIntArray()
    }

    private fun going(i: Int, j: Int, k: Int, grid: Array<String>): Int {
        var result = 0
        val pos = Pos(i, j, k)

        if(set.contains(pos)){
            return 0
        }

        set.add(pos)
        result ++

        var (y, x, d) = pos

        while (true) {
            y = (y + dy[d] + row) % row
            x = (x + dx[d] + column) % column

            if (grid[y][x] == 'S') {
                d = d
            } else if (grid[y][x] == 'L') {
                d = (d - 1 + 4) % 4
            } else if (grid[y][x] == 'R') {
                d = (d + 1 + 4) % 4
            }

            val nextPos = Pos(y, x, d)

            if (set.contains(nextPos)) {
                break
            }

            set.add(nextPos)
            result++
        }

        return result
    }
}

data class Pos(
    val y: Int,
    val x: Int,
    val direction: Int
)