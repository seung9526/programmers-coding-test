class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        // 옷 종류별 개수를 저장할 맵 생성
        val clothesMap = mutableMapOf<String, Int>()
        
        for (item in clothes) {
            val type = item[1]
            // 해당 의상 종류의 개수를 증가시킴
            clothesMap[type] = clothesMap.getOrDefault(type, 0) + 1
        }
        println("의상 종류별 개수: $clothesMap") // 맵에 저장된 의상 종류별 개수 출력
    
        var combinations = 1
        
        for (count in clothesMap.values) {
            // 각 종류별 입지 않는 경우까지 포함하여 조합 개수를 계산
            combinations *= (count + 1)
            println("현재까지 조합 수: $combinations") // 중간 계산 단계 출력
        }
        
        // 아무것도 입지 않는 경우를 제외한 최종 결과 반환
        println("최종 조합 수 (아무것도 입지 않는 경우 제외): ${combinations - 1}")
        return combinations - 1
    }
}
