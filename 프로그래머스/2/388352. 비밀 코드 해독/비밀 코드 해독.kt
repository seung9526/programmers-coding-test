class Solution {
    fun solution(n: Int, attempts: Array<IntArray>, correctCounts: IntArray): Int {
        val dp = Array(n + 1) { IntArray(6) } // 최대 5개 선택 가능, 0~5 인덱스 사용
        dp[0][0] = 1 // 0개 선택하는 경우 1가지 (아무것도 선택 안함)

        for (i in 1..n) {
            for (j in 0..5) {
                dp[i][j] = dp[i - 1][j] // 현재 숫자를 선택하지 않는 경우
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1] // 현재 숫자를 선택하는 경우
                }
            }
        }

        val totalCombinations = dp[n][5] // n개에서 5개를 선택하는 조합 개수

        var validCount = 0
        for (combination in generateCombinations(n, 5)) {
            if (attempts.indices.all { i ->
                    combination.count { it in attempts[i] } == correctCounts[i]
                }) {
                validCount++
            }
        }

        return validCount
    }

    // 조합을 미리 생성 (DP와 조합을 활용하여 미리 생성)
    private fun generateCombinations(n: Int, k: Int): List<Set<Int>> {
        val result = mutableListOf<Set<Int>>()
        val numbers = (1..n).toList()

        fun combine(start: Int, selected: MutableList<Int>) {
            if (selected.size == k) {
                result.add(selected.toSet()) // 조합 추가
                return
            }
            for (i in start until n) {
                selected.add(numbers[i])
                combine(i + 1, selected)
                selected.removeAt(selected.lastIndex)
            }
        }

        combine(0, mutableListOf())
        return result
    }
}
