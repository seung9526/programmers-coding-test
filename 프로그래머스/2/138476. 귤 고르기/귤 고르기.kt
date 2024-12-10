class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        // 1. 귤 크기별 빈도 계산
        val frequencyMap = tangerine.toList().groupingBy { it }.eachCount()

        // 2. 빈도를 내림차순으로 정렬
        val sorted = frequencyMap.values.sortedDescending()

        // 3. 최소 크기 종류 계산
        var count = 0 // 종류 수
        var total = 0 // 선택한 귤의 총 개수
        for (frequency in sorted) {
            total += frequency
            count++
            if (total >= k) break // k개 이상 선택되면 종료
        }
        return count
    }
}
