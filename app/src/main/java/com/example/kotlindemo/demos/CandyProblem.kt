package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object CandyProblem : Solution<IntArray>() {

    private fun candyDistribution(k: Int, n: Int): IntArray {
        val distribution = IntArray(k) { 0 }
        var totalCandy = n
        var j = 0
        while (totalCandy > 0) {
            for (i in 0..k) {
                j++
                if (totalCandy < 0) {
                    break
                } else {
                    if (totalCandy > j) {
                        distribution[i] += j
                    } else {
                        distribution[i] += totalCandy
                    }
                    totalCandy -= j
                }
            }
        }
        distribution.forEach {
            println(it)
        }
        return distribution
    }

    fun candyDistribution2(k: Int, n: Int): IntArray {
        val distribution = IntArray(k) { 0 }
        var remainingCandies = n
        var i = 0
        while (remainingCandies > 0) {
            val candiesToDistribute = minOf(remainingCandies, i + 1)
            distribution[i % k] += candiesToDistribute
            remainingCandies -= candiesToDistribute
            i++
        }

        distribution.forEach { println(it) }
        return distribution
    }

    override var className: String = "CandyProblem"
    override var result: IntArray = intArrayOf()

    override fun solution() {
        result = candyDistribution(4, 7)
        printResult()
    }


}