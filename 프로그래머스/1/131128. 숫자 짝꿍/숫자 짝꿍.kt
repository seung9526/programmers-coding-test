class Solution {
    fun solution(X: String, Y: String): String {
    val xCount = IntArray(10)
    val yCount = IntArray(10)

    for (ch in X) xCount[ch - '0']++
    for (ch in Y) yCount[ch - '0']++

    val result = StringBuilder()

    for (i in 9 downTo 0) {
        val count = minOf(xCount[i], yCount[i])
        repeat(count) { result.append(i) }
    }

    if (result.isEmpty()) return "-1"
    if (result.all { it == '0' }) return "0"

    return result.toString()
    }
}