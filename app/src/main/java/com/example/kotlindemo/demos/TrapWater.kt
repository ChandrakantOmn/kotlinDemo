package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object TrapWater: Solution<Int>() {
    private fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0
        val n = height.size
        var left  = 0
        var right =  n-1
        var leftMax = 0
        var rightMax = 0
        var trappedWater = 0
        //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]

        while (left < right) {
            if (height[left] < height[right]) { // 0<1
                if (height[left] > leftMax) { //0 > 0
                    leftMax = height[left]
                } else {
                    trappedWater += leftMax - height[left]
                }
                left++
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right]
                } else {
                    trappedWater += rightMax - height[right]
                }
                right--
            }
        }

        return trappedWater

    }

    override var className: String = "TrapWater"
    override var result: Int  =0



    override fun solution() {
        //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //Output: 6
        result = (trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
        printResult()
    }
}