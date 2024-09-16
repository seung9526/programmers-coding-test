func solution(n int, k int) int {
    mainCost := n * 12000
    
    drinksCost := k * 2000
    
    freeDrinksCost := (n / 10) * 2000
    
    totalCost := mainCost + drinksCost - freeDrinksCost
    
    return totalCost
}