class Solution {
    fun solution(board: Array<String>): Int {
        var flatBoard = board.joinToString("")
        val countO = flatBoard.count { it == 'O' }
        val countX = flatBoard.count { it == 'X' }
        
        if (countO != countX && countO != countX + 1) return 0  
        
        val winO = isWin(board, 'O')
        val winX = isWin(board, 'X')
        
        if (winO && winX) return 0

        if (winO && countO != countX + 1) return 0

        if (winX && countO != countX) return 0

        return 1
    }

        private fun isWin(board: Array<String>, player: Char): Boolean {
        val winPatterns = arrayOf(

            listOf(0 to 0, 0 to 1, 0 to 2),
            listOf(1 to 0, 1 to 1, 1 to 2),
            listOf(2 to 0, 2 to 1, 2 to 2),

            listOf(0 to 0, 1 to 0, 2 to 0),
            listOf(0 to 1, 1 to 1, 2 to 1),
            listOf(0 to 2, 1 to 2, 2 to 2),

            listOf(0 to 0, 1 to 1, 2 to 2),
            listOf(0 to 2, 1 to 1, 2 to 0)
        )

        return winPatterns.any { pattern ->
            pattern.all { (r, c) -> board[r][c] == player }
        }
    }
}