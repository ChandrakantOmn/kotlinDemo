package com.example.kotlindemo.medium

import com.example.kotlindemo.Solution

object StringZigzagConversion : Solution<String>() {
    override var className: String = "StringZigzagConversion"
    override var result: String = ""

    override fun solution() {
        result = stringZigzagConversion(string="PAYPALISHIRING",numRows= 4)
        printResult()
        printResult(result == "PINALSIGYAHRPI")
    }

    private fun stringZigzagConversion(string: String, numRows: Int): String {
        if (numRows == 1 || string.length <= numRows) {
            return string;
        }
        val zigzag = Array(numRows) { StringBuilder() }
        var row = 0
        var goingDown = false

        for (char in string) {
            zigzag[row].append(char)

            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown
            }

            row += if (goingDown) 1 else -1
        }
        val result = StringBuilder()
        for (rowStringBuilder in zigzag) {
            result.append(rowStringBuilder)
        }
        return result.toString()

    }
}