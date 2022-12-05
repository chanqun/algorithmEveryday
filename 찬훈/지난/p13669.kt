import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var array = Array<Long>(36) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()

    array[0] = 1
    array[1] = 1

    for (i in 2..N) {

        for (j in 0 until i) {
            array[i] += array[(i - 1) - j] * array[j]
        }
    }

    println(array[N])
}

