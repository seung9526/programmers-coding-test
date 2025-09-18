func solution() {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let start = input[0]
    let target = input[1]

    if start == target {
        print(0)
        print(start)
        return
    }

    var visited = Array(repeating: -1, count: 100_001)
    var queue: ArraySlice<Int> = [start][...]  // BFS queue를 ArraySlice로
    var depth = 0

    while !queue.isEmpty {
        depth += 1
        let currentLevel = queue
        queue = []  // 다음 레벨 준비

        for cur in currentLevel {
            for next in [cur - 1, cur + 1, cur * 2] {
                if (0...100_000).contains(next), visited[next] == -1 {
                    visited[next] = cur
                    queue.append(next)
                    if next == target {  // 목표 도착 시 바로 경로 출력
                        print(depth)
                        var path = [target]
                        var pre = target
                        while pre != start {
                            pre = visited[pre]
                            path.append(pre)
                        }
                        print(path.reversed().map { String($0) }.joined(separator: " "))
                        return
                    }
                }
            }
        }
    }
}

solution()
