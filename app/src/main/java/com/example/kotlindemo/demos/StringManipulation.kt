package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution
import java.util.LinkedList

object StringManipulation : Solution<Array<String>>(){
    override var className: String = "StringManipulation"

    override var result = emptyArray<String>()

    override fun solution() {
     //  result = findAllSubstrings("FUN")
     val ss =  longestSubstringWithoutRepeatingCharacters(input="ABCDEFGABCDEFGIJ")
        println(ss)
    }

    private fun longestSubstringWithoutRepeatingCharacters(input: String): String {
        val charQueue = LinkedList<Char>()
        var longestSubString = ""
        for (element in input) {
            if (!charQueue.contains(element)) {
                charQueue.add(element)
                if (charQueue.size > longestSubString.length) {
                    longestSubString = charQueue.joinToString("")
                }
            } else {
                while (charQueue.contains(element)) {
                    charQueue.removeFirst()
                }
                charQueue.add(element)
            }
        }

        return longestSubString

    }

    private fun findAllSubstrings(input: String): Array<String> {
        val length = input.length
        val substrings = mutableListOf<String>()
        for (start in 0 until length) {
            for (end in start + 1..length) {
                substrings.add(input.substring(start, end))
            }
        }
        return substrings.toTypedArray()
    }
    fun printType(data: Any) {
        val dataType = data::class.simpleName
        println("Type of data: $dataType")
    }
}