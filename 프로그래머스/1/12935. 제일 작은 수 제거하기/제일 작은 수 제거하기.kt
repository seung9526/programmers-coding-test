class Solution {
    fun solution(arr: IntArray): IntArray {
        val minValue = arr.minOrNull() ?: return intArrayOf(-1)
        val result = arr.filter { it != minValue }.toIntArray()
        
        return if (result.isEmpty()) intArrayOf(-1) else result
    }
}