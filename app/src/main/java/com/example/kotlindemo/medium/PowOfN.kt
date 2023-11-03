package com.example.kotlindemo.medium

import com.example.kotlindemo.Solution

object PowOfN : Solution<Double>() {
    override var className: String  = "PowOfN"
    override var result: Double  =0.0
    override fun solution() {
        result = powerOfN2(value = 2.0, exponent= 10)
        printResult()
    }

    private fun powerOfN(value: Double, exponent: Int): Double {
        var result = 1.0
        for ( i in 0 until  exponent){
            result *= value
        }
        return  result
    }

    private fun powerOfN2(value: Double, exponent: Int): Double {
        if (exponent == 0) {
            return 1.0
        }
        var result = 1.0
        var base = value
        var exp = exponent

        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base
            }
            base *= base
            exp /= 2
        }
        return result
    }

}