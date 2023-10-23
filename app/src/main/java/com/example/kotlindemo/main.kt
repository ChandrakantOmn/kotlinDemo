package com.example.kotlindemo

import com.example.kotlindemo.demos.Asteroid
import com.example.kotlindemo.demos.CandyProblem
import com.example.kotlindemo.demos.Factorial
import com.example.kotlindemo.demos.Fibonacci
import com.example.kotlindemo.demos.MergeIntervals
import com.example.kotlindemo.demos.Palindrome
import com.example.kotlindemo.demos.RegularExpression
import com.example.kotlindemo.demos.ReverseInteger
import com.example.kotlindemo.demos.StringManipulation
import com.example.kotlindemo.demos.TaskScheduler
import com.example.kotlindemo.demos.TrapWater
import com.example.kotlindemo.demos.TwoSumArray
import com.example.kotlindemo.demos.WordSearch

fun main() {
    runCode(WordSearch.className)
}
fun runCode(choice: String) {
    when (choice) {
        Asteroid.className -> Asteroid.solution()
        CandyProblem.className -> CandyProblem.solution()
        Factorial.className -> Factorial.solution()
        Fibonacci.className -> Fibonacci.solution()
        Palindrome.className -> Palindrome.solution()
        ReverseInteger.className -> ReverseInteger.solution()
        StringManipulation.className -> StringManipulation.solution()
        TaskScheduler.className -> TaskScheduler.solution()
        TrapWater.className -> TrapWater.solution()
        TwoSumArray.className -> TwoSumArray.solution()
        RegularExpression.className -> RegularExpression.solution()
        MergeIntervals.className -> MergeIntervals.solution()
        WordSearch.className -> WordSearch.solution()
        else -> println("Invalid choice")
    }
}


abstract class Solution<T> {
    abstract var  className : String
    abstract var result: T
    abstract fun solution()
    open fun printResult() {
        println("$className:Result: $result")
    }
}
