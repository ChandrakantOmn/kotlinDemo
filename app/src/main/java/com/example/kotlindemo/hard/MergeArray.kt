package com.example.kotlindemo.hard

import com.example.kotlindemo.Solution

object MergeArray : Solution<Double>() {
    override var className: String = "MergeArray"
    override var result: Double = 0.0

    override fun solution() {
       result = getMedianOf2Array(intArrayOf(1,2,5), intArrayOf(1,2,3,4))//2
       result = getMedianOf2Array(intArrayOf(1,2,5), intArrayOf(3,4))//3
       result = getMedianOf2Array(intArrayOf(1,2), intArrayOf(3,4))// 2.5
        printResult()
    }

    private fun getMedianOf2Array(array: IntArray, array2: IntArray): Double {
        val mergedArray= mergeArray(array, array2)
        val mid = (mergedArray.size / 2)
        return if (mergedArray.size % 2 == 0 ){
            ((mergedArray[mid] + mergedArray[mid-1])).toDouble()/2
        }else{
            mergedArray[mid].toDouble()
        }
    }


    private fun getMedianOf2sortedArray(array1: IntArray, array2: IntArray): Double {
        val totalLength = array1.size + array2.size
        val halfLength = totalLength / 2

        if (array1.isEmpty() && array2.isEmpty()) {
            return 0.0
        }

        if (array1.isEmpty()) {
            return if (totalLength % 2 == 0) {
                (array2[halfLength - 1].toDouble() + array2[halfLength].toDouble()) / 2.0
            } else {
                array2[halfLength].toDouble()
            }
        }

        if (array2.isEmpty()) {
            return if (totalLength % 2 == 0) {
                (array1[halfLength - 1].toDouble() + array1[halfLength].toDouble()) / 2.0
            } else {
                array1[halfLength].toDouble()
            }
        }

        var i = 0
        var j = 0
        var current = 0
        var prev = 0

        while (i + j <= halfLength) {
            prev = current

            if (i < array1.size && (j == array2.size || array1[i] <= array2[j])) {
                current = array1[i]
                i++
            } else {
                current = array2[j]
                j++
            }
        }

        return if (totalLength % 2 == 0) {
            (prev.toDouble() + current.toDouble()) / 2.0
        } else {
            current.toDouble()
        }
    }


    private fun mergeArray2(array: IntArray, array2: IntArray): IntArray {
        val merged = IntArray(array.size + array2.size)
        var i = 0
        var j = 0
        var k = 0

        while (i < array.size && j < array2.size) {
            if (array[i] < array2[j]) {
                merged[k++] = array[i++]
            } else {
                merged[k++] = array2[j++]
            }
        }

        while (i < array.size) {
            merged[k++] = array[i++]
        }

        while (j < array2.size) {
            merged[k++] = array2[j++]
        }

        return merged
    }

    private fun mergeArray(array: IntArray, array2: IntArray): IntArray {
        val list = mutableListOf<Int>()
       var i = 0
       var j = 0

        while (list.size< (array.size+ array2.size)){
            if (i< array.size && j< array2.size){
                if (array[i]< array2[j]){
                    list.add(array[i])
                    i += 1
                }else{
                    list.add(array2[j])
                    j += 1
                }
            } else if (i< array.size){
                list.add(array[i])
                i += 1
            }else{
                list.add(array2[j])
                j += 1
            }

        }

        list.forEach { println(it) }
        return  list.toIntArray()
    }
}