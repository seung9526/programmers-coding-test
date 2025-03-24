class Solution {
    fun solution(s: String): String {
    val mid = s.length / 2  // 가운데 인덱스

    return if (s.length % 2 == 0) {
            s.substring(mid - 1, mid + 1)  // 짝수일 때: 가운데 두 글자 반환
        } else {
            s[mid].toString()  // 홀수일 때: 가운데 한 글자 반환
        }
    }
}