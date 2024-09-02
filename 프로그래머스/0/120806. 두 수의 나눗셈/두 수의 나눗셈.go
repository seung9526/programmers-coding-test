func solution(num1 int, num2 int) int {
    number1, number2 := float32(num1), float32(num2)
    divi := number1 / number2
    result := int (divi * 1000)
    return  result
}