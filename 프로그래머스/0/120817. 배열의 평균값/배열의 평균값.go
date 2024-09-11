func solution(numbers []int) float64 {
    var sum int
    
    for _, num := range numbers {
        sum += num
    }
    
    return float64(sum) / float64(len(numbers))
}