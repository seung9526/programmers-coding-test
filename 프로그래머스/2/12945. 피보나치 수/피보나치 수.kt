class Solution {
    fun solution(n: Int): Int {
        val mod = 1234567
        var a = 0
        var b = 1

        for (i in 2..n) {
            val temp = (a + b) % mod
            a = b
            b = temp
        }

        return b
    }
}
