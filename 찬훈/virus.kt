import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


var array = ArrayList<ArrayList<Int>>()
var check = Array(1000) { false }
var m = 0
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    m = br.readLine().toInt()
    n = br.readLine().toInt()

    for (i in 0..m) {
        array.add(ArrayList<Int>())
    }

    for (i in 1..n) {
        val token = StringTokenizer(br.readLine())

        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()

        array[a].add(b)
        array[b].add(a)
    }

    println(bfs(1))
}

fun bfs(node: Int): Int {
    var count = 0

    val q: Queue<Int> = LinkedList()
    q.offer(node)
    check[node] = true

    while (!q.isEmpty()) {
        val x = q.poll()
        check[x] = true

        for (y in 0 until array[x].size) {
            val nextNode = array[x][y]

            if (!check[nextNode]) {
                q.add(nextNode)
                count++
                check[nextNode] = true
            }
        }
    }

    return count
}