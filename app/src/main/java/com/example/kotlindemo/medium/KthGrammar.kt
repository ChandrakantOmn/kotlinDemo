package com.example.kotlindemo.medium

import com.example.kotlindemo.Solution
/*
 We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
 Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
  and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
* */
object KthGrammar: Solution<String>() {
    override var className: String  = "KthGrammar"
    override var result: String = ""

    override fun solution() {
        result = kthGrammar(n= 5, k = 6)
        printResult()
        result = kthGrammar2(n= 5, k = 6).toString()
        printResult()
    }

    private fun kthGrammar(n: Int, k: Int): String {
        var lastRow = ""
        for (i in 0 until n){
            if (i == 0){
                lastRow = "0"
            }else{
                var temp = ""
                for (s in lastRow.toCharArray()){
                    temp += if (s.toString() == "0") "01" else "10"
                }
                lastRow = temp
            }
            println(lastRow)

        }

        return  lastRow.toCharArray()[k-1].toString()
    }

    private fun kthGrammar2(n: Int, k: Int): Int {
        if (n == 1) {
            return 0
        }

        val mid = (1 shl (n - 2))
        return if (k <= mid) {
            kthGrammar2(n - 1, k)
        } else {
            1 - kthGrammar2(n - 1, k - mid)
        }
    }

}