package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution
/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 */
object WordSearch : Solution<Boolean>() {
    override var className: String = "WordSearch"
    override var result: Boolean = false


    override fun solution() {
        val input1  = arrayOf(charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E'))
        val input2  = arrayOf(charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E'))
        val startTime = System.currentTimeMillis()
      //  result = exist(input1, word = "ABCCED")
      //  printResult()
     //   result = exist(input1, word = "ABCD")
    //    printResult()
        result = exist2(input2, word = "SEE")
        printResult()
        val endTime = System.currentTimeMillis()
        val totalTime = endTime - startTime
        println("Time taken to complete the program: $totalTime milliseconds")

        println("Time taken to complete the program: $totalTime milliseconds")
    }

    private fun exist(board: Array<CharArray>, word: String): Boolean {
        var  p = 0
        var  currentChar = word[p]
        val list = mutableListOf<Point>()
        var lastValidPosition = Point(0,0)
        var y = 0
        while (true){
            for (arr in board){
                for ((x, c) in arr.withIndex()){
                    if (list.isEmpty()) {
                        if (c == currentChar) {
                            lastValidPosition = Point(x, y)
                            list.add(lastValidPosition)
                            p++
                            currentChar= word[p]
                        }
                    }else{
                        val points = getValidPoint(lastValidPosition, arr.size-1, board.size-1)
                     var recordNotFound =  true
                       for (point in points){
                           if (currentChar == board[point.y][point.x]  && !list.contains(point)){
                               lastValidPosition =point
                               list.add(lastValidPosition)
                               if (list.size == word.length){
                                   return true
                               }else{
                                   p++
                                   currentChar= word[p]
                               }
                               recordNotFound = false
                           }
                       }
                        if (recordNotFound){
                            p--
                            currentChar= word[p]
                            list.clear()
                            lastValidPosition = Point(-1,-1)
                        }
                    }
                }
                y++
            }
            return false
        }
    }

    private fun getValidPoint(lastValidPosition: Point, arrSize: Int, boardSize: Int): List<Point> {
        val list  =  mutableListOf<Point>()

        if (lastValidPosition.x < arrSize){
            list.add(Point(lastValidPosition.x+1, lastValidPosition.y))

        }
        if (lastValidPosition.x>0){
            list.add(Point(lastValidPosition.x-1, lastValidPosition.y))
        }

        if (lastValidPosition.y< boardSize){
            list.add(Point(lastValidPosition.x, lastValidPosition.y+1))

        }
        if (lastValidPosition.y>0){
            list.add(Point(lastValidPosition.x, lastValidPosition.y-1))
        }
        return  list
    }


    private fun exist2(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size

        fun dfs(x: Int, y: Int, idx: Int): Boolean {
            if (x < 0 || x >= cols || y < 0 || y >= rows || board[y][x] != word[idx]) {
                return false
            }

            if (idx == word.length - 1) {
                return true
            }

            val originalChar = board[y][x]
            board[y][x] = '#' // Mark the cell as visited

            val found = dfs(x + 1, y, idx + 1) || dfs(x - 1, y, idx + 1) ||
                    dfs(x, y + 1, idx + 1) || dfs(x, y - 1, idx + 1)

            board[y][x] = originalChar // Restore the cell
            return found
        }

        for (y in 0 until rows) {
            for (x in 0 until cols) {
                if (board[y][x] == word[0] && dfs(x, y, 0)) {
                    return true
                }
            }
        }

        return false
    }


}

data class  Point(var x : Int = 0, var y : Int = 0)