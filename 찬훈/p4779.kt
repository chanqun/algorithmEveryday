import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    while (sc.hasNextInt()) {
        val n = sc.nextInt()
        var answer = "-"

        repeat(n) {
            answer = sol(answer)
        }

        println(answer)
    }
}

fun sol(s: String): String {
    return s + " ".repeat(s.length) + s
}
