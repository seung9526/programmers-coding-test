fun allocateBudgetGreedy(requests: IntArray, totalBudget: Int): Int {
    requests.sort() // 요청 예산을 오름차순으로 정렬
    var remainingBudget = totalBudget
    var answer = 0

    for (i in requests.indices) {
        val countRemaining = requests.size - i

        // 요청이 남은 예산을 초과하는 경우: 상한액 계산
        if (remainingBudget < requests[i] * countRemaining) {
            answer = remainingBudget / countRemaining
            break
        }

        // 요청을 그대로 반영 가능할 경우: 요청만큼 예산을 줄임
        remainingBudget -= requests[i]
    }

    // 상한액이 0인 경우, 모든 요청을 배정한 것이므로 최댓값 반환
    return if (answer == 0) requests.last() else answer
}

fun main() {
    // 입력 데이터 예시
    val n = readLine()!!.toInt()
    val requests = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val totalBudget = readLine()!!.toInt()

    // 예산 배정 결과 출력
    println(allocateBudgetGreedy(requests, totalBudget))
}