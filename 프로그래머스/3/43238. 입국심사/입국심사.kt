class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var left = 1L
        var right = n * times.maxOrNull()!!.toLong() // 최대 시간은 n명의 사람이 가장 느린 심사관에게만 심사를 받는 경우

        while (left < right) {
            val mid = (left + right) / 2
            
            // mid 시간 동안 처리할 수 있는 사람 수 계산
            val processed = times.sumOf { mid / it }
            
            if (processed < n) {
                left = mid + 1 // 처리할 수 있는 사람이 부족하면 시간을 늘림
            } else {
                right = mid // 충분히 처리할 수 있으면 시간을 줄여봄
            }
        }

        return left // left가 최솟값
    }
}
