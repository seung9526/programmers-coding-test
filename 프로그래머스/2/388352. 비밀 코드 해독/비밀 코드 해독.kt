import kotlin.math.*
import kotlin.collections.*

class Solution {
    fun solution(n: Int, attempts: Array<IntArray>, correctCounts: IntArray): Int {
        // 1️⃣ 가능한 모든 5개 숫자 조합 생성 (라이브러리 활용)
        val allPossibleCodes = (1..n).toList().combinations(5).map { it.toSet() }

        // 2️⃣ 각 조합이 주어진 시도(입력)와 시스템 응답(맞은 개수) 조건을 만족하는지 확인
        return allPossibleCodes.count { secretCode ->
            attempts.indices.all { i ->
                val matchingNumbers = secretCode.intersect(attempts[i].toSet()).size
                matchingNumbers == correctCounts[i]
            }
        }
    }

    // 조합을 구하는 확장 함수 (Kotlin에는 기본적으로 없음 -> 직접 구현)
    private fun <T> List<T>.combinations(k: Int): List<List<T>> {
        val result = mutableListOf<List<T>>()
        fun combine(start: Int, selected: MutableList<T>) {
            if (selected.size == k) {
                result.add(ArrayList(selected)) // 완성된 조합 추가
                return
            }
            for (i in start until this.size) {
                selected.add(this[i])
                combine(i + 1, selected)
                selected.removeAt(selected.size - 1) // 백트래킹
            }
        }
        combine(0, mutableListOf())
        return result
    }
}