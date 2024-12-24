import Foundation

func solution() {
    var t = 0
    while true {
        let N = Int(readLine()!)!
        if N == 0 { break }
        t += 1
        
        var map = [[Int]]()
        for _ in 0..<N {
            map.append(readLine()!.split(separator: " ").map { Int(String($0))! })
        }
        
        // 최단경로 테이블 생성
        var result = Array(repeating: Array(repeating: 1000000, count: N), count: N)
        result[0][0] = map[0][0]  
        
        // 우선순위 큐 초기화 (f값, x, y)
        var pq = [(Int, Int, Int)]()  
        pq.append((map[0][0] + estimateDistance(0, 0, N-1, N-1), 0, 0))  
        
        // A* 알고리즘을 이용하여 최단 경로를 구함
        while !pq.isEmpty {
            pq.sort { $0.0 < $1.0 } 
            let (currentF, x, y) = pq.removeFirst()
            let dx = [0, 0, 1, -1]
            let dy = [1, -1, 0, 0]
            
            for i in 0..<4 {
                let nx = x + dx[i]
                let ny = y + dy[i]
                
                if nx >= 0, nx < N, ny >= 0, ny < N {
                    let gCost = result[x][y] + map[nx][ny]
                    let hCost = estimateDistance(nx, ny, N-1, N-1)  
                    let newF = gCost + hCost
                    
                    if gCost < result[nx][ny] {
                        result[nx][ny] = gCost
                        pq.append((newF, nx, ny)) 
                    }
                }
            }
        }
          print("Problem \(t): \(result[N-1][N-1])")
    }
}

func estimateDistance(_ x: Int, _ y: Int, _ goalX: Int, _ goalY: Int) -> Int {
    return abs(x - goalX) + abs(y - goalY)
}

solution()