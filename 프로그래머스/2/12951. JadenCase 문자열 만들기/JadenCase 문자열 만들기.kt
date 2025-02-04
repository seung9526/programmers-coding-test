class Solution {
    fun solution(s: String): String {
        return s.lowercase().split(" ").joinToString(" ") { word ->
        if (word.isNotEmpty()) word.replaceFirstChar { it.uppercase() } else word
        }
    }
}