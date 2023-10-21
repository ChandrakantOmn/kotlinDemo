package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution
/*  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
Example 1:
Input: s = "aa", p = "a"
Output: false

Input: s = "aa", p = "a*"
Output: true

Input: s = "ab", p = ".*"
Output: true
Explanation: "a" does not match the entire string "aa".
* */
object RegularExpression : Solution<Boolean>() {
    override var className: String = "RegularExpression"
    override var result: Boolean = false
    override fun solution() {
      //  result = isMatchingThePattern("ab", ".*")
        println(isMatch("aa", "a"))     // Output: false
        println(isMatch("aa", "a*"))    // Output: true
        println(isMatch("ab", ".*"))    // Output: true
     //   printResult()
    }
        private fun isMatch(s: String, p: String): Boolean {
            val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
            dp[0][0] = true

            for (j in 1..p.length) {
                if (p[j - 1] == '*') {
                    dp[0][j] = dp[0][j - 2]
                }
            }

            for (i in 1..s.length) {
                for (j in 1..p.length) {
                    if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else if (p[j - 1] == '*') {
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'))
                    }
                }
            }

            return dp[s.length][p.length]
        }


}
