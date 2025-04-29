class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer = 0 
    var paintedUntil = 0 

    for (pos in section) { 
        if (pos > paintedUntil) { 
            answer++ 
            paintedUntil = pos + m - 1
        }
    }

    return answer
    }
}