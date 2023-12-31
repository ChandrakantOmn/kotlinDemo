package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object Palindrome : Solution<Boolean>() {
    override var className: String = "Palindrome"
    override var result: Boolean = false
    override fun solution() {
        //result  = "abbaa".isStringPalindrome()
     //   result = 123454321.isPalindrome()
        val longestPalindrome = longestPalindrome(string="abababd")
        printResult(longestPalindrome)

    }

    private fun longestPalindrome(string: String): String {
        var longest = ""
        for (i in string.indices) {
            for (j in i + 1 until string.length + 1) {
                val subString = string.substring(i, j)
                if (subString.isStringPalindrome() && subString.length > longest.length) {
                    longest = subString
                }
            }
        }
        return longest
    }
    private fun String.isStringPalindrome(): Boolean {
        var left = 0
        var right = this.length - 1
        while (left < right) {
            if (this[left] != this[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

private fun Int.isPalindrome(): Boolean {
    var temp = this
    var reverse = 0
    while (temp != 0) {
        val mod = temp % 10
        reverse = (reverse * 10) + mod
        temp /= 10
    }
    return reverse == this
}
