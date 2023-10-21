package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object Factorial : Solution<Int>() {
    override var className: String = "Factorial"
    override var result: Int = 0

    override fun solution(){
        result = (factorial(2))
        printResult()
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