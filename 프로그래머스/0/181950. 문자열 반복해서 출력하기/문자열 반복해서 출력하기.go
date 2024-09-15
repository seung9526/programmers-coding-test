package main

import (
    "fmt"
    "strconv"
    "strings"
)

func main() {
    var s1 string
    var a string
    fmt.Scan(&s1, &a)
    
    n, _ := strconv.Atoi(a)
    
    result := strings.Repeat(s1, n)
    
    fmt.Println(result)
}