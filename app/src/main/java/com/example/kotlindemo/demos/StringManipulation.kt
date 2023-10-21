package com.example.kotlindemo.demos

import com.example.kotlindemo.Solution

object StringManipulation : Solution<String>(){
    override var className: String = "StringManipulation"

    override var result: String = ""

    override fun solution() {
            findAllSubstring("FUN")
    }

    private fun findAllSubstring(input: String) {
        val length = input.length
        val list =  input.toCharArray().toList()
        for (i in 1 until length+1){
            list.windowed(i).forEach {
                it.forEach {
                    println(it)
                }
            }
        }


/*
        for (start in 0 until length) {
            for (end in start + 1..length) {
                val substring = input.substring(start, end)
                println(substring)
            }
        }
*/

    }

    fun printType(data: Any) {
        val dataType = data::class.simpleName
        println("Type of data: $dataType")
    }
}