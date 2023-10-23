package com.example.kotlindemo.easy

import com.example.kotlindemo.Solution

/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].*/
object RomanInteger : Solution<Int>() {
    override var className: String = "RomanInteger"
    override var result: Int = 0

    override fun solution() {
     //   result = getRomanToInt("LVIII") //58
       // result = getRomanToInt2("MCMXCIV") //1994
     //   result = getRomanToInt("VXM")
     //   printResult()
       // result = getRomanToInt2("XIX")//19
        result = romanToInt("VXM")
        printResult()
    }

    private fun getRomanToInt(s: String): Int {
        var r = 0
        var x = 0
        while (x < s.length ) {
            val c = s[x]
                val v = when (c) {
                    'I' -> if ( (x+1 <s.length) &&  s[x + 1] == 'V') {
                        x += 2
                        4
                    } else if ((x+1 <s.length) && s[x + 1] == 'X') {
                        x += 2
                        9
                    } else {
                        x += 1
                        1
                    }

                    'V' -> {
                        x += 1
                        5
                    }

                    'X' -> if ((x+1 <s.length) && s[x + 1] == 'L') {
                        x += 2
                        40
                    } else if ((x+1 <s.length) &&s[x + 1] == 'C') {
                        x += 2
                        90
                    } else {
                        x += 1
                        10
                    }

                    'L' -> {
                        x += 1
                        50
                    }

                    'C' -> if ((x+1 <s.length) && s[x + 1] == 'D') {
                        x += 2
                        400
                    } else if ((x+1 <s.length) && s[x + 1] == 'M') {
                        x += 2
                        900
                    } else {
                        x += 1
                        100
                    }

                    'D' -> {
                        x += 1
                        500
                    }

                    'M' -> {
                        x+= 1
                        1000
                    }
                    else -> 0
                }
                r += v
            println("r $r : x: $x c: $c")

        }
        return r
    }

    private fun getRomanToInt2(s: String): Int {
        val romanToInteger = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var result = 0
        var index = 0

        while (index < s.length) {
            val currentChar = s[index]
            val currentVal = romanToInteger[currentChar] ?: 0
            val nextIndex = index + 1
            if (nextIndex < s.length) {
                val nextChar = s[nextIndex]
                val nextVal = romanToInteger[nextChar] ?: 0

                if (nextVal > currentVal) {
                    result += (nextVal - currentVal)
                    index = nextIndex + 1
                } else {
                    result += currentVal
                    index = nextIndex
                }
            } else {
                result += currentVal
                index = nextIndex
            }
        }

        return result
    }


    private fun romanToInt(s: String): Int {
         val rm2I = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var res = 0
        var i = 0
        while (i < s.length) {
            if (i == s.length-1) {
                res += rm2I[s[i]]!!
                break
            }
            if (rm2I[s[i]]!! < rm2I[s[i+1]]!!) {
                res += rm2I[s[i+1]]!!-rm2I[s[i]]!!
                i += 2
            } else {
                res += rm2I[s[i]]!!
                i++
            }
        }
        return res
    }
}