package me.kzv.programmers.level1

fun main() {
    val id_list = arrayOf(
        "muzi", "frodo", "apeach", "neo"
    )

    val report = arrayOf(
        "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "apeach muzi"
    )

    solution(id_list, report, 2)
}

/**
 * report 신고 당한 명단
 * id_list 명단
 */

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    var answer: IntArray = intArrayOf() // 신고 통지 받을 개수 배열
    val reportedList = mutableMapOf<String, MutableList<String>>()
    val alertList = mutableMapOf<String, Int>()

    makeReportedList(report, reportedList)
    makeAlertList(id_list, alertList)

    reportedList.forEach {
        addAlert(reportedList, it, k, alertList)
    }

    answer = listToArray(id_list, alertList)

    return answer
}

private fun listToArray(
    id_list: Array<String>,
    alertList: MutableMap<String, Int>
): IntArray {
    return id_list.map { id ->
        alertList[id] ?: 0
    }.toIntArray()
}

private fun addAlert(
    reportedList: MutableMap<String, MutableList<String>>,
    it: Map.Entry<String, MutableList<String>>,
    k: Int,
    alertList: MutableMap<String, Int>
) {
    if (reportedList[it.key]!!.size >= k) {
        it.value.forEach { id ->
            alertList[id] = alertList[id]!! + 1
        }
    }
}

private fun makeAlertList(
    id_list: Array<String>,
    alertList: MutableMap<String, Int>
) {
    id_list.forEach {
        alertList[it] = 0
    }
}

private fun makeReportedList(
    reports: Array<String>,
    reportedList: MutableMap<String, MutableList<String>>
) {
    reports.toSet().forEach {
        val (user, target) = it.split(" ")

        reportedList[target]?.add(user) ?: run {
            reportedList[target] = mutableListOf(user)
        }
    }
}


class Solution1 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf() // 신고 통지 받을 개수 배열
        val reportedList = mutableMapOf<String, MutableList<String>>()
        val alertList = mutableMapOf<String, Int>()

        val reports = report.toSet()

        reports.forEach {
            val (user, target) = it.split(" ")

            reportedList[target]?.add(user) ?: run {
                reportedList[target] = mutableListOf(user)
            }
        }

        id_list.forEach {
            alertList[it] = 0
        }

        reportedList.forEach {
            if(reportedList[it.key]!!.size >= k) {
                it.value.forEach{ id ->
                    alertList[id] = alertList[id]!! + 1
                }
            }
        }

        answer = id_list.map {
                id -> alertList[id] ?: 0
        }.toIntArray()

        return answer
    }
}