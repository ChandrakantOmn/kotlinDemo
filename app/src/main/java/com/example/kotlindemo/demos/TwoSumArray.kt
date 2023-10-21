package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

object TwoSumArray : Solution<IntArray>() {
    override var className: String = "TwoSumArray"
    override var result: IntArray = intArrayOf()
    override fun solution(){
        getExactOnePairs(intArrayOf(2,7,11,15, -2),target= 9).forEach {
            println(it)
        }
    }

    private fun getExactOnePairs(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (complement in map) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }

    private fun getPairs(intArrayOf: IntArray, target: Int): List<Map<Int, Int>> {
        val map = mutableMapOf<Int, Int>()
        intArrayOf.forEachIndexed { index, i ->
            val component = target - i
            if (intArrayOf.contains(component)) {
                if (!(map.containsKey(index) || (map.containsKey(intArrayOf.indexOf(component))))) {
                    if (index < intArrayOf.indexOf(component)) {
                        map[index] = intArrayOf.indexOf(component)
                    } else {
                        map[intArrayOf.indexOf(component)] = index
                    }
                }

            }
        }
        return map.entries.map { entry -> mapOf(entry.key to entry.value) }
    }
}