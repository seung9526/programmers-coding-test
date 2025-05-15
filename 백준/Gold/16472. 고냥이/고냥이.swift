func solution() {
    let N = Int(readLine()!)!
    let translator = readLine()!.map { String ($0) }
    
    var alphabetCount = Array(repeating: 0, count: 26) // a~z
    var count = 0 
    
    var result = 0

    var left = 0 
    var right = 0

    alphabetCount[Int(translator[left].unicodeScalars.first!.value) - 97] += 1
    count += 1
    
    while right < translator.count - 1 {
        right += 1
        
        let rightIndex = Int(translator[right].unicodeScalars.first!.value) - 97
        alphabetCount[rightIndex] += 1
        
        if alphabetCount[rightIndex] == 1 { 
            count += 1
        }
        
        while count > N {
            let leftIndex = Int(translator[left].unicodeScalars.first!.value) - 97
            alphabetCount[leftIndex] -= 1
            if alphabetCount[leftIndex] == 0 {
                count -= 1
            }
            left += 1
        }
        
        result = max(result, right-left+1)
    }
    print(result)
}

solution()