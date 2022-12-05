import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val queue: Queue<Int> = LinkedList()
val visit = Array(101) { 0 }
val map = HashMap<Int, Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    for (i in 0 until n + m) {
        st = StringTokenizer(br.readLine())

        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        map[start] = end
    }

    queue.add(1)
    visit[1] = 0

    while (!queue.isEmpty()) {
        val now = queue.poll()

        for (i in 1..6) {
            var next = now + i

            if (next > 100) {
                continue
            }

            if (map.containsKey(next)) {
                next = map[next]!!
            }

            if (visit[next] == 0) {
                visit[next] = visit[now] + 1
                queue.add(next)
            }
        }
    }

    println(visit[100])
}
