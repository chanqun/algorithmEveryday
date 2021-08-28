import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var arrayList = ArrayList<ArrayList<Int>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    for (i in 0 .. n + 1) {
        arrayList.add(arrayListOf())
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        arrayList[start].add(end)
    }

    val answer = bfs(x, k, n + 1)

    if (answer.isEmpty()) {
        println(-1)
    } else {
        answer.sort()
        answer.forEach {
            println(it)
        }
    }
}

fun bfs(start: Int, distance: Int, n: Int): ArrayList<Int> {
    val visit = BooleanArray(n)
    val answerList = arrayListOf<Int>()

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(start, 0))
    visit[start] = true

    while (!queue.isEmpty()) {
        val (x, d) = queue.poll()

        if (d == distance) {
            answerList.add(x)
        }
        if (d > distance) {
            break
        }

        for (i in 0 until arrayList[x].size) {
            val nx = arrayList[x][i]
            if (visit[nx]) continue

            visit[nx] = true
            queue.add(Pair(nx, d + 1))
        }
    }

    return answerList
}
