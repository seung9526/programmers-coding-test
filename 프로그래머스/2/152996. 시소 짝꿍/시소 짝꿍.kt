class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        
        // 몸무게를 오름차순으로 정렬
        weights.sort()

        val map = mutableMapOf<Double, Int>() // 토크 값에 대한 카운트

        for (w in weights) {
            val a = w * 1.0  // 몸무게 * 1
            val b = (w * 2.0) / 3.0  // 몸무게 * 2/3
            val c = (w * 1.0) / 2.0  // 몸무게 * 1/2
            val d = (w * 3.0) / 4.0  // 몸무게 * 3/4
            
            // 이미 해당 토크 값이 존재한다면 그 값만큼 짝을 이룬다고 간주
            if (map.containsKey(a)) answer += map[a]!!.toLong()
            if (map.containsKey(b)) answer += map[b]!!.toLong()
            if (map.containsKey(c)) answer += map[c]!!.toLong()
            if (map.containsKey(d)) answer += map[d]!!.toLong()

            // 해당 토크 값 카운트
            map[a] = map.getOrDefault(a, 0) + 1
        }

        return answer
    }
}
