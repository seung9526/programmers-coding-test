class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        
        for (n in left..right) {
            val divisorCount = countDivisors(n)
            if (divisorCount % 2 == 0) answer += n else answer -= n
        }
        
        return answer
    }
    
    fun countDivisors(n: Int): Int {
        var count = 0

        for (i in 1..n) {
            if (n % i == 0) count++
        }
        return count
    }
}