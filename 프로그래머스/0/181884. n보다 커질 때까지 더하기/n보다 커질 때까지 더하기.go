func solution(numbers []int, n int) int {
    sum := 0
    for _, num := range numbers {
        sum += num
        if sum > n {
            break
        }
    }
    return sum
}
