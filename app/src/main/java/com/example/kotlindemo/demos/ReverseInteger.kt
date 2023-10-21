package com.example.kotlindemo.demos


abstract class Solution<T> {
    abstract var result: T
    abstract fun solution()
    open fun printResult() {
        println(result)
    }}

class ReverseInteger : Solution<Int>() {
    override var result: Int = 0
    override fun solution() {
        result = 123.reverse()
        printResult()
    }
}


private fun Int.reverse(): Int {
    var reversenum = 0
    var num = this
    while (num != 0) {
        val mod = num % 10 //2 rn =30
        reversenum = (reversenum * 10) + mod //30+20
        num /= 10
    }
    return reversenum
}

private fun getReverseNumber(n: Int): Int {
    var reverseNum = 0
    var number = n
    while (number != 0) {
        val digit = number % 10
        reverseNum = reverseNum * 10 + digit
        number /= 10
    }
    return reverseNum
}

