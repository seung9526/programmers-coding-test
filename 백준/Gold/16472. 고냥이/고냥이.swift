func solution() {
    let N = Int(readLine()!)!
    let input = Array(readLine()!) // 바로 Character 배열로 변환

    var alphabetCount = [Int](repeating: 0, count: 26)
    var uniqueCount = 0
    var maxLength = 0

    var left = 0

    for right in 0..<input.count {
        let rightIndex = Int(input[right].asciiValue! - Character("a").asciiValue!)
        alphabetCount[rightIndex] += 1
        if alphabetCount[rightIndex] == 1 {
            uniqueCount += 1
        }

        while uniqueCount > N {
            let leftIndex = Int(input[left].asciiValue! - Character("a").asciiValue!)
            alphabetCount[leftIndex] -= 1
            if alphabetCount[leftIndex] == 0 {
                uniqueCount -= 1
            }
            left += 1
        }

        maxLength = max(maxLength, right - left + 1)
    }

    print(maxLength)
}

solution()