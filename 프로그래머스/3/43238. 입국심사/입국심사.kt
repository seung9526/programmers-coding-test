class Solution {
    fun solution(n: Int, times: IntArray): Long {
        val m = times.size
        var left = 1L
        var right = n * times.maxOrNull()!!.toLong()
        var result = right

        while (left <= right) {
            val mid = (left + right) / 2
            
            // mid 시간 동안 처리할 수 있는 총 인원 수 계산
            var processedPeople = 0L
            for (time in times) {
                processedPeople += mid / time
                if (processedPeople >= n) break // 더 이상 계산할 필요 없음
            }

            if (processedPeople >= n) {
                result = mid // 처리 가능한 인원이 충분하므로 시간을 줄인다
                right = mid - 1
            } else {
                left = mid + 1 // 처리 가능한 인원이 부족하므로 시간을 늘린다
            }
        }
        
        return result
    }
}
