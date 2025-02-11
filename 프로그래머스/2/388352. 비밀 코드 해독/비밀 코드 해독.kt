import kotlin.math.*

class Solution {
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        // 모든 5개 숫자 조합 생성
        val allCombinations = generateCombinations(n)

        // 가능한 비밀 코드 조합 필터링
        return allCombinations.count { candidate ->
            q.indices.all { i -> candidate.intersect(q[i].toSet()).size == ans[i] }
        }
    }

    // 1부터 n까지의 숫자로 이루어진 모든 5개 조합 생성
    private fun generateCombinations(n: Int): List<Set<Int>> {
        val result = mutableListOf<Set<Int>>()
        val numbers = (1..n).toList()

        fun combine(start: Int, combination: MutableList<Int>) {
            if (combination.size == 5) {
                result.add(combination.toSet())
                return
            }
            for (i in start until n) {
                combination.add(numbers[i])
                combine(i + 1, combination)
                combination.removeAt(combination.lastIndex)
            }
        }

        combine(0, mutableListOf())
        return result
    }
}
