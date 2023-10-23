package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution
import java.util.Arrays
import java.util.Stack

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
object MergeIntervals : Solution<String>() {
    override var className: String
        get() = "MergeIntervals"
        set(value) {}
    override var result: String =""


    override fun solution() {
     //  result = mergeIntervals(arrayOf(intArrayOf(1,3), intArrayOf(2,6),intArrayOf(8,10),intArrayOf(15,18)))
       result = mergeIntervals2(arrayOf(intArrayOf(1,3), intArrayOf(2,6),intArrayOf(8,10), intArrayOf(9,14), intArrayOf(15,18)))
    }

    private fun mergeIntervals(array: Array<IntArray>): String {
        val arrays = array.sortedBy { it[0] }
        val list = mutableListOf<IntArray>()
        var start = arrays[0][0]
        var end = arrays[0][1]
            for (i in 1 until  arrays.size){
              if (arrays[i][0]<end){
                  end = arrays[i][1]
              }else{
                  list.add(intArrayOf(start, end))
                  start = arrays[i][0]
                  end = arrays[i][1]
              }
            }
        list.add(intArrayOf(start, end))

        list.forEach {
            println("${it[0]} : ${it[1]}")
        }


        return  ""

    }

    private fun mergeIntervals2(arr: Array<IntArray>): String {
        if (arr.isEmpty()) return ""
        val stack: Stack<IntArray> = Stack<IntArray>()
        Arrays.sort(arr) { t, t2 -> t[0] - t2[1] }
        stack.push(arr[0])
        for (i in 1 until arr.size) {
            val top: IntArray = stack.peek()
            if (top[1] < arr[i][0]) stack.push(arr[i]) else if (top[1] < arr[i][1]) {
                top[1] = arr[i][1]
                stack.pop()
                stack.push(top)
            }
        }
        print("The Merged Intervals are: ")
        while (!stack.isEmpty()) {
            val t: IntArray = stack.pop()
            print("[" + t[0] + "," + t[1] + "] "
            )
        }
        return ""
    }



}


