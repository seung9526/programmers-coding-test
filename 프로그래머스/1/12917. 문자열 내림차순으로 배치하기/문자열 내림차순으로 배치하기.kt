class Solution {
    fun solution(s: String): String {
        var answer = s.toList().sortedDescending().joinToString("")
        return answer
    }
}