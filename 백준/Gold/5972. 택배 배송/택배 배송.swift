import Foundation

func solution() {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let N = input[0]
    let M = input[1]

    var graph = [[(Int, Int)]](repeating: [], count: N)

    for _ in 0..<M {
        let path = readLine()!.split(separator: " ").map { Int($0)! }
        let A = path[0] - 1
        let B = path[1] - 1
        let C = path[2]
        graph[A].append((B, C))
        graph[B].append((A, C))
    }

    // **탐색 순서 최적화: 간선 정렬**
    for i in 0..<N {
        graph[i].sort { $0.1 < $1.1 }
    }

    var distances = [Int](repeating: Int.max, count: N)
    distances[0] = 0

    var queue = [(Int, Int)]()
    queue.reserveCapacity(N)
    queue.append((0, 0))
    
    var queueIndex = 0  // **deque처럼 사용 (O(1) pop)**

    while queueIndex < queue.count {
        let (current, currentCost) = queue[queueIndex]
        queueIndex += 1

        if currentCost > distances[current] { continue }

        for (next, edgeCost) in graph[current] {
            let newCost = currentCost + edgeCost

            if newCost < distances[next] {
                distances[next] = newCost
                queue.append((next, newCost))
            }
        }

        // **배열 크기가 커지면 한 번에 정리 (O(1) 복사)**
        if queueIndex > 1000 {
            queue = Array(queue[queueIndex...]) // **빠른 슬라이싱**
            queueIndex = 0
        }
    }

    print(distances[N - 1])
}

solution()
