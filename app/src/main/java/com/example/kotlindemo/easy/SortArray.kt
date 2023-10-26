package com.example.kotlindemo.easy

import com.example.kotlindemo.Solution

object SortArray : Solution<IntArray>() {
    override var className: String = "SortArray"
    override var result: IntArray = intArrayOf()

    override fun solution() {
        // result = bubbleSort(intArrayOf(1, 5, 8, 3, 6, 11, 1))
        result = selectionSort(intArrayOf(1, 5, 8, 3, 6, 11, 1))
        result.forEach { println(it) }
    }


    private fun quickSort(arr: IntArray) {
        quickSort(arr, 0, arr.size - 1)
    }

    private fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            // Partition the array and get the pivot index
            val pivotIndex = partition(arr, low, high)

            // Recursively sort the elements on both sides of the pivot
            quickSort(arr, low, pivotIndex - 1)
            quickSort(arr, pivotIndex + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        // Choose the rightmost element as the pivot
        val pivot = arr[high]
        var i = low - 1

        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                swap(arr, i, j)
            }
        }

        // Swap the pivot element with the element at (i+1)
        swap(arr, i + 1, high)

        return i + 1
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }


    private fun insertionSort(arr: IntArray): IntArray {
        for (i in 1 until arr.size) {
            val currentElement = arr[i]
            var j = i - 1
            // Shift elements in the sorted region to the right until the correct position for currentElement is found.
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j]
                j--
            }
            // Insert currentElement into its correct position.
            arr[j + 1] = currentElement
        }

        return arr
    }



    /*Selection Sort:
Divides the input list into a sorted and an unsorted region.
Repeatedly selects the minimum element from the unsorted region and moves it to the end of the sorted region.
Time complexity: O(n^2) in the worst case.*/
    private fun selectionSort(arr: IntArray): IntArray {
        val sorted = arr.copyOf()
        for (i in 0 until arr.size - 1) {
            var minIndex = i
            for (j in i + 1 until arr.size) {
                if (sorted[j] < sorted[minIndex]) {
                    minIndex = j
                }
            }
            val temp = sorted[i]
            sorted[i] = sorted[minIndex]
            sorted[minIndex] = temp
        }
        return sorted
    }

    /*Bubble Sort:

A simple comparison-based sorting algorithm.
Repeatedly steps through the list, compares adjacent elements,
and swaps them if they are in the wrong order.
Time complexity: O(n^2) in the worst case.*/
    private fun bubbleSort(arr: IntArray): IntArray {
        var n = arr.size
        var isSwapped: Boolean
        do {
            isSwapped = false
            for (i in 1 until n) {
                if (arr[i - 1] > arr[i]) {
                    val temp = arr[i - 1]
                    arr[i - 1] = arr[i]
                    arr[i] = temp
                    isSwapped = true
                }
            }
            n--
        } while (isSwapped)

        return arr
    }
}