import kotlin.math.pow

fun minOperations(n: Long): Long {
    val num = n.toString(2)
    val len = num.length

    var result = 0L
    var sign = 1

    for (i in 0 until len) {
        var number =  Character.getNumericValue(num[i])

        var power: Long = if (number > 0) {
            2.toDouble().pow(len - (i + 1)).toLong()
        } else {
            0L
        }

        var step = number * (power * 2 - 1)

        result += step * sign
        sign *= if (number == 0) 1 else -1
    }

    return result
}