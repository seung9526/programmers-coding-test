class Solution {
    fun solution(ingredient: IntArray): Int {
        val stack = mutableListOf<Int>()
        var count = 0

        for (item in ingredient) {
            stack.add(item)

            if (stack.size >= 4 && stack.takeLast(4) == listOf(1, 2, 3, 1)) {
                repeat(4) { 
                    stack.removeAt(stack.size - 1) 
                }
                count++
            }
        }
        
        return count
    }
}