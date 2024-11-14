fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val matrix = Array(N + 1) { BooleanArray(N + 1) }

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        // a -> b 대소관계 측정 가능
        matrix[a][b] = true
    }

    for (i in 1..N) {
        matrix[i][i] = true
        for (j in 1..N) {
            for (k in 1..N) {
                if (matrix[j][i] && matrix[i][k]) {
                    matrix[j][k] = true
                }
            }
        }
    }

    for (i in 1..N) {
        var result = 0

        for (j in 1..N) {
            // i -> j 불가능하고, j -> i 불가능하면, i와 j는 대소비교 불가능
            if (!matrix[i][j] && !matrix[j][i]) result++
        }
        println(result)
    }
}