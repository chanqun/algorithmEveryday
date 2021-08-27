import java.io.BufferedReader
import java.io.InputStreamReader

val numList = ArrayList<String>()
val set = HashSet<Int>()
var n = 0
var k = 0
var visit = BooleanArray(10)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toInt()
    k = br.readLine().toInt()

    for (i in 0 until n) {
        val temp = br.readLine()

        numList.add(temp)
    }

    combi(0, "")

    println(set.size)
}

fun combi(idx: Int, s: String) {
    if (idx == k) {
        set.add(s.toInt())
        return
    } else {
        for (i in 0 until n) {
            if (!visit[i]) {
                visit[i] = true
                combi(idx + 1, s + numList[i])
                visit[i] = false
            }
        }
    }
}
