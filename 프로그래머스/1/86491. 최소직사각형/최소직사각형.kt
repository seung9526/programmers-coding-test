class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxW = 0
        var maxH = 0
        
        for (size in sizes) {
            val width = maxOf(size[0], size[1])
            val hidth = minOf(size[0], size[1])
            
            maxW = maxOf(maxW, width)
            maxH = maxOf(maxH, hidth)
        }
        
        return maxW * maxH
    }
}