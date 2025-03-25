import Foundation

func solution() {
    // 입력 처리
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    let N = input[0]  // 헛간 수
    let M = input[1]  // 길 수
    
    // 인접 리스트 (각 노드에서 연결된 다른 노드들로의 경로와 비용)
    var graph = Array(repeating: [(node: Int, cost: Int)](), count: N)
    
    // 길 정보 입력 처리
    for _ in 0..<M {
        let path = readLine()!.split(separator: " ").map { Int(String($0))! }
        let A = path[0] - 1
        let B = path[1] - 1
        let C = path[2]
        graph[A].append((B, C))
        graph[B].append((A, C))
    }
    
    // 각 헛간까지의 최소 여물 비용을 저장하는 배열
    var distances = Array(repeating: Int.max, count: N)
    distances[0] = 0
    
    // 다이나믹 프로그래밍 + 탐욕 알고리즘 하이브리드 접근
    var queue = [0]  // 탐색할 노드 큐
    
    while !queue.isEmpty {
        var nextQueue = [Int]()
        
        for current in queue {
            for (next, cost) in graph[current] {
                let newCost = distances[current] + cost
                
                // 더 짧은 경로 발견 시
                if newCost < distances[next] {
                    distances[next] = newCost
                    nextQueue.append(next)
                }
            }
        }
        
        // 중복 제거 및 정렬 최소화
        queue = Array(Set(nextQueue))
    }
    
    // 결과 출력
    print(distances[N-1])
}

solution()