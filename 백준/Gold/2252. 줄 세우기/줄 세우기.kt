import java.util.*

fun main() {
    // 입력 받기
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    
    // 그래프와 차수 초기화
    val graph = Array(N + 1) { mutableListOf<Int>() }
    val indegree = IntArray(N + 1) { 0 }
    
    // 비교 결과 바탕으로 그래프 생성
    repeat(M) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        graph[a].add(b)  // a -> b
        indegree[b]++    // b의 차수 증가
    }

    // 위상 정렬을 위한 큐 (차수가 0인 노드부터 시작)
    val queue: Queue<Int> = LinkedList()

    // 차수가 0인 노드를 큐에 넣기
    for (i in 1..N) {
        if (indegree[i] == 0) {
            queue.offer(i)
        }
    }

    // 위상 정렬을 위한 결과 리스트
    val result = mutableListOf<Int>()

    // 위상 정렬 수행
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        result.add(node)

        // 현재 노드에 연결된 모든 노드들의 차수를 감소
        for (neighbor in graph[node]) {
            indegree[neighbor]--
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }

    // 위상 정렬을 끝낸 후, 모든 노드를 출력해야 한다면 N개가 출력되어야 함
    if (result.size == N) {
        println(result.joinToString(" "))
    } else {
        // 사이클이 있을 경우 (위상 정렬이 안 된 경우)
        println("사이클이 존재합니다.")
    }
}
