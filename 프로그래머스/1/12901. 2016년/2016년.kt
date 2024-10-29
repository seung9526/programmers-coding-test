class Solution {
    fun solution(a: Int, b: Int): String {
        // 일수를 저장
        val daysInMonth = arrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        
        // 요일 배열을 정의
        val daysOfWeek = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        
        // 총 며칠이 지났는지 계산
        val totalDays = (0 until a - 1).sumOf { daysInMonth[it] } + b
        
        // 4. 1월 1일은 금요일(인덱스 5). 총 일수에 따라 요일을 구합니다.
        val dayIndex = (5 + totalDays - 1) % 7
        
        return daysOfWeek[dayIndex]
    }
}
