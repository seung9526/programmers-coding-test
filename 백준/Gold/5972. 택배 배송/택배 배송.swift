import Foundation

func solution() {
    // 입력 처리 최적화
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let N = input[0]
    let M = input[1]
    
    // 그래프 메모리 최적화
    var graph = [[(node: Int, cost: Int)]](repeating: [], count: N)
    
    // 길 정보 입력 처리 최적화
    for _ in 0..<M {
        let path = readLine()!.split(separator: " ").map { Int($0)! }
        let A = path[0] - 1
        let B = path[1] - 1
        let C = path[2]
        graph[A].append((B, C))
        graph[B].append((A, C))
    }
    
    // 거리 배열 초기화
    var distances = [Int](repeating: Int.max, count: N)
    distances[0] = 0
    
    // 더 효율적인 큐 관리
    var queue = [(node: Int, cost: Int)]()
    queue.reserveCapacity(N)
    queue.append((0, 0))
    
    var queueIndex = 0
    
    while queueIndex < queue.count {
        let (current, currentCost) = queue[queueIndex]
        queueIndex += 1
        
        // 이미 더 짧은 경로 발견된 경우 스킵
        if currentCost > distances[current] { continue }
        
        // 인접 노드 탐색
        for (next, edgeCost) in graph[current] {
            let newCost = currentCost + edgeCost
            
            if newCost < distances[next] {
                distances[next] = newCost
                queue.append((next, newCost))
            }
        }
    }
    
    // 결과 출력
    print(distances[N-1])
}

solution()