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

    // **탐색 순서 최적화: 간선 정렬 (가중치가 작은 순)**
    for i in 0..<N {
        graph[i].sort { $0.1 < $1.1 }
    }

    var distances = [Int](repeating: Int.max, count: N)
    distances[0] = 0

    var queue = [(Int, Int)]()
    queue.reserveCapacity(N)
    queue.append((0, 0))
    
    var queueIndex = 0

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

        // **배열 접근 최적화 (메모리 재할당 최소화)**
        if queueIndex > 1000 {
            queue.removeFirst(queueIndex)
            queueIndex = 0
        }
    }

    print(distances[N - 1])
}

solution()
