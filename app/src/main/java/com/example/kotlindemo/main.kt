package com.example.kotlindemo

import com.example.kotlindemo.demos.Asteroid
import com.example.kotlindemo.demos.CandyProblem
import com.example.kotlindemo.demos.Factorial
import com.example.kotlindemo.demos.Fibonacci
import com.example.kotlindemo.demos.Palindrome
import com.example.kotlindemo.demos.ReverseInteger
import com.example.kotlindemo.demos.StringManipulation
import com.example.kotlindemo.demos.TaskScheduler
import com.example.kotlindemo.demos.TrapWater
import com.example.kotlindemo.demos.TwoSumArray

fun main() {
    val choice = StringManipulation.className
    when (choice) {
        "Asteroid" -> Asteroid.solution()
        "CandyProblem" -> CandyProblem.solution()
        "Factorial" -> Factorial.solution()
        "Fibonacci" -> Fibonacci.solution()
        "Palindrome" -> Palindrome.solution()
        "ReverseInteger" -> ReverseInteger.solution()
        "StringManipulation" -> StringManipulation.solution()
        "TaskScheduler" -> TaskScheduler.solution()
        "TrapWater" -> TrapWater.solution()
        "TwoSumArray" -> TwoSumArray.solution()
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
