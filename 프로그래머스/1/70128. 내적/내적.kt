class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.zip(b).sumOf { (x, y) -> x * y }
    }
}