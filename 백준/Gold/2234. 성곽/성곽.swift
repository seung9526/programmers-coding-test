import Foundation

let dx = [0, -1, 0, 1] // 서, 북, 동, 남
let dy = [-1, 0, 1, 0]
let wall = [1, 2, 4, 8]

let input = readLine()!.split(separator: " ").map { Int($0)! }
let cols = input[0], rows = input[1]

var castle = (0..<rows).map { _ in readLine()!.split(separator: " ").map { Int($0)! } }
var visited = Array(repeating: Array(repeating: false, count: cols), count: rows)
var roomMap = Array(repeating: Array(repeating: 0, count: cols), count: rows)
var roomSizes = [0] // index = room number

func bfs(_ x: Int, _ y: Int, _ roomId: Int) -> Int {
    var q = [(x, y)]
    visited[x][y] = true
    roomMap[x][y] = roomId
    var size = 1
    var idx = 0

    while idx < q.count {
        let (cx, cy) = q[idx]
        idx += 1

        for d in 0..<4 {
            let nx = cx + dx[d]
            let ny = cy + dy[d]

            if nx < 0 || nx >= rows || ny < 0 || ny >= cols { continue }
            if visited[nx][ny] { continue }
            if castle[cx][cy] & wall[d] != 0 { continue }

            visited[nx][ny] = true
            roomMap[nx][ny] = roomId
            q.append((nx, ny))
            size += 1
        }
    }
    return size
}

func analyzeRooms() {
    var roomId = 1
    for i in 0..<rows {
        for j in 0..<cols {
            if !visited[i][j] {
                let size = bfs(i, j, roomId)
                roomSizes.append(size)
                roomId += 1
            }
        }
    }
}

func maxRoomAfterBreakingWall() -> Int {
    var maxSize = 0
    for i in 0..<rows {
        for j in 0..<cols {
            let currRoom = roomMap[i][j]
            for d in 0..<4 {
                let ni = i + dx[d]
                let nj = j + dy[d]
                if ni < 0 || ni >= rows || nj < 0 || nj >= cols { continue }

                let nextRoom = roomMap[ni][nj]
                if currRoom != nextRoom {
                    maxSize = max(maxSize, roomSizes[currRoom] + roomSizes[nextRoom])
                }
            }
        }
    }
    return maxSize
}

// 🧠 실행
analyzeRooms()
print(roomSizes.count - 1)        // 총 방 개수
print(roomSizes.max()!)           // 가장 큰 방 크기
print(maxRoomAfterBreakingWall()) // 벽 하나 없앴을 때 최대 방 크기