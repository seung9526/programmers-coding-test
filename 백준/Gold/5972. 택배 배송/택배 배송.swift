import Foundation

func solution() {
    // 🏃 FileHandle로 빠르게 입력 읽기
    let file = FileHandle.standardInput
    let data = file.readDataToEndOfFile()
    let input = String(data: data, encoding: .utf8)!.split(separator: "\n")
    
    // 🚀 첫 번째 줄 입력 처리 (N, M)
    let firstLine = input[0].split(separator: " ").map { Int($0)! }
    let N = firstLine[0], M = firstLine[1]
    
    // 🚀 그래프 초기화 (메모리 최적화)
    var graph = [[(node: Int, cost: Int)]](repeating: [], count: N)

    // 🚀 간선 입력 처리 최적화
    for i in 1...M {
        let path = input[i].split(separator: " ").map { Int($0)! }
        let A = path[0] - 1, B = path[1] - 1, C = path[2]
        graph[A].append((B, C))
        graph[B].append((A, C))
    }

    // 🚀 거리 배열 초기화 (더 빠른 인덱스 접근)
    var distances = [Int](repeating: Int.max, count: N)
    distances[0] = 0

    // 🚀 더 빠른 큐 관리 (Array 대신 Queue처럼 사용)
    var queue = [(node: Int, cost: Int)]()
    queue.reserveCapacity(N)
    queue.append((0, 0))
    
    var queueIndex = 0  // 🚀 pop을 최적화하기 위한 인덱스
    
    // 🚀 최단 거리 탐색 (O(N^2) → 개선 가능)
    while queueIndex < queue.count {
        let (current, currentCost) = queue[queueIndex]
        queueIndex += 1
        
        // 🚀 이미 더 짧은 경로가 있다면 스킵
        if currentCost > distances[current] { continue }

        // 🚀 인접 노드 탐색
        for (next, edgeCost) in graph[current] {
            let newCost = currentCost + edgeCost

            if newCost < distances[next] {
                distances[next] = newCost
                queue.append((next, newCost))
            }
        }
    }
    
    // 🚀 결과 출력 최적화
    print(distances[N-1])
}

solution()
