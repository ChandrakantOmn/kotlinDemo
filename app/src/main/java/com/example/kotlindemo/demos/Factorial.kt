package com.example.kotlindemo.demos

object Factorial {
    fun solution(){
        print(factorial(2))
    }

    private fun factorial(i: Int): Int {
        if (i == 0) return  1
        var a = 1
        for ( k in 1 until i+1){
            a *= k
        }
        return a
    }
}