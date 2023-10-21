package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object Fibonacci : Solution<IntArray>() {
    override var className: String = "Fibonacci"
    override var result: IntArray = intArrayOf()

    override fun solution(){
        result = (fibonacci2(9)).toIntArray()
    }

    private fun fibonacci2(i: Int): List<Int> {
        if (i <= 0) {
            return emptyList()
        }
        val fibonacciNumbers = mutableListOf(0)
        if (i >= 1) {
            fibonacciNumbers.add(1)
        }
        var a = 0
        var b = 1
        for (k in 1 until i) {
            val c = a + b
            a = b
            b = c
            fibonacciNumbers.add(c)
        }
        return fibonacciNumbers
    }

}