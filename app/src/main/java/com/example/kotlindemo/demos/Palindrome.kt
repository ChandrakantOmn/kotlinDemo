package com.example.kotlindemo.demos

class Palindrome : Solution<Boolean>() {
    override var result: Boolean = false
    override fun solution() {
         //result  = "abbaa".isStringPalindrome()
        result = 123454321.isPalindrome()
        printResult()

    }
    private fun String.isStringPalindrome(): Boolean {
        var left = 0
        var right = this.length-1
        while (left<right){
            if (this[left] != this[right]){
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
    while (temp != 0  ){
        val mod  = temp % 10
        reverse = (reverse * 10) + mod
        temp /= 10
    }
    return  reverse == this
}
