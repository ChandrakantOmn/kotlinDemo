package com.example.kotlindemo

object Fibonacci {
    fun solution(){
       // fibonacci(2)
        println(fibonacci2(9))
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