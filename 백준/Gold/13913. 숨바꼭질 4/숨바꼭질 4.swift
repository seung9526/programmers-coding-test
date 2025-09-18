func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    let N = input[0]
    let K = input[1]

    if N == K {
        print(0)
        print(N)
        return
    }

    var visited = Array(repeating: -1, count: 100_001) // 이전 좌표 저장
    var queue = [N]
    var depth = 0

    while !queue.isEmpty {
        depth += 1
        var nextQueue = [Int]()

        // lazy sequence 적용: 필요한 값만 필터링
        queue.lazy.forEach { cur in
            if cur == K {
                print(depth - 1)
                var path = [K]
                var pre = K
                while pre != N, pre != -1 {
                    pre = visited[pre]
                    path.append(pre)
                }
                print(path.reversed().map(String.init).joined(separator: " "))
                return
            }

            [cur - 1, cur + 1, cur * 2].lazy
                .filter { (0...100_000).contains($0) && visited[$0] == -1 }
                .forEach { n in
                    nextQueue.append(n)
                    visited[n] = cur
                }
        }

        queue = nextQueue
    }
}

solution()
