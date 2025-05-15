func solution() {
    let N = Int(readLine()!)!
    let translator = readLine()!.map { String($0) }

    var left = 0
    var right = 0

    var result = 0
    var visited = Set<String>()
    var charCount = [String: Int]()

    while right < translator.count {
        let char = translator[right]
        charCount[char, default: 0] += 1
        visited.insert(char)

        while visited.count > N {
            let leftChar = translator[left]
            charCount[leftChar]! -= 1
            if charCount[leftChar]! == 0 {
                charCount.removeValue(forKey: leftChar)
                visited.remove(leftChar)
            }
            left += 1
        }

        result = max(result, right - left + 1)
        right += 1
    }

    print(result)
}

solution()
