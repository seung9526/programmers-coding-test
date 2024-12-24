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
        result[0][0] = map[0][0]  // 시작점 초기화
        
        // 우선순위 큐 초기화 (f값, x, y)
        var pq = PriorityQueue<(Int, Int, Int)>{ $0.0 < $1.0 }  // f값이 작은 순으로 정렬
        pq.push((map[0][0] + estimateDistance(0, 0, N-1, N-1), 0, 0))  // (f값, x, y)
        
        // A* 알고리즘을 이용하여 최단 경로를 구함
        while !pq.isEmpty {
            let (currentF, x, y) = pq.pop()!
            
            // 이미 더 낮은 비용으로 처리된 경로라면 건너뛰기
            if currentF != result[x][y] + estimateDistance(x, y, N-1, N-1) {
                continue
            }
            
            // 4방향 탐색
            let dx = [0, 0, 1, -1]
            let dy = [1, -1, 0, 0]
            
            for i in 0..<4 {
                let nx = x + dx[i]
                let ny = y + dy[i]
                
                if nx >= 0, nx < N, ny >= 0, ny < N {
                    let gCost = result[x][y] + map[nx][ny]
                    let hCost = estimateDistance(nx, ny, N-1, N-1)  // 목표 지점까지의 예상 비용
                    let newF = gCost + hCost
                    
                    if gCost < result[nx][ny] {
                        result[nx][ny] = gCost
                        pq.push((newF, nx, ny))  // f값을 우선적으로 추가
                    }
                }
            }
        }
        
        // 결과 출력
        print("Problem \(t): \(result[N-1][N-1])")
    }
}

// 목표 지점까지의 휴리스틱 (직선 거리) 계산 함수
func estimateDistance(_ x: Int, _ y: Int, _ goalX: Int, _ goalY: Int) -> Int {
    // 직선 거리 (맨하탄 거리 또는 유클리드 거리 등)
    return abs(x - goalX) + abs(y - goalY)
}

// 우선순위 큐 구현 (Swift에서 PriorityQueue는 내장되어 있지 않음)
struct PriorityQueue<Element> {
    private var heap: [Element]
    private let areSorted: (Element, Element) -> Bool

    init(sort: @escaping (Element, Element) -> Bool) {
        self.heap = []
        self.areSorted = sort
    }

    var isEmpty: Bool {
        return heap.isEmpty
    }

    mutating func push(_ element: Element) {
        heap.append(element)
        siftUp(heap.count - 1)
    }

    mutating func pop() -> Element? {
        guard !isEmpty else { return nil }
        heap.swapAt(0, heap.count - 1)
        let result = heap.removeLast()
        siftDown(0)
        return result
    }

    private mutating func siftUp(_ index: Int) {
        var child = index
        var parent = (child - 1) / 2
        while child > 0 && areSorted(heap[child], heap[parent]) {
            heap.swapAt(child, parent)
            child = parent
            parent = (child - 1) / 2
        }
    }

    private mutating func siftDown(_ index: Int) {
        var parent = index
        var leftChild = 2 * parent + 1
        var rightChild = 2 * parent + 2
        var smallest = parent
        
        if leftChild < heap.count && areSorted(heap[leftChild], heap[smallest]) {
            smallest = leftChild
        }
        if rightChild < heap.count && areSorted(heap[rightChild], heap[smallest]) {
            smallest = rightChild
        }
        if smallest != parent {
            heap.swapAt(parent, smallest)
            siftDown(smallest)
        }
    }
}

solution()
