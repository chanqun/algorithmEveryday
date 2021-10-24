fun cardinalitySort(nums: Array<Int>): Array<Int> {
    val result = Array<Int>(nums.size) { 0 }

    var arrayList = arrayListOf<Pair<Int, Int>>()

    nums.forEach {
        val binary = it.toString(2)

        var count = 0
        binary.forEach { char ->
            if (char == '1') {
                count++
            }
        }

        arrayList.add(Pair(it, count))
    }

    val list = arrayList.sortedWith(compareBy({ it.second }, { it.first }))

    for (i in nums.indices) {
        result[i] = list[i].first
    }

    return result
}