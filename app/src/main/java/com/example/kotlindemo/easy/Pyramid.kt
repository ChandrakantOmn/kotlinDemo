package com.example.kotlindemo.easy

import com.example.kotlindemo.Solution

object Pyramid : Solution<Any>() {
    override var className: String = "Pyramid"
    override var result: Any = ""

    override fun solution() {
        reversePyramid(5)
        pyramid(5)
        centerPyramid(5)
        reverseCenterPyramid(5)
    }

    private fun printStars(number: Int) {
        for (j in number downTo 1) {
            for (k in 0 until number - j) {
                print(" ")
            }
            for (i in 0 until j) {
                print("*")
            }
            println("")
        }
    }

    private fun pyramid(n: Int){
        for (i in 0 until n){
            print("*".repeat(i+1))
            println()
        }
    }
    private fun centerPyramid(n: Int){

        for (i in 0 until n) {

            for (j in n - i downTo 2) {
                print(" ")
            }
            for (j in 0..i) {
                print("* ")
            }

            // ending line after each row
            println()
        }
    }
    private fun reverseCenterPyramid(n: Int){

        for (i in 0 until n) {

            for (j in n - i downTo 2) {
                print("* ")
            }
            for (j in 0..i) {
                print(" ")
            }

            // ending line after each row
            println()
        }
    }

    private fun reversePyramid(n: Int){
        for (i in n downTo 1){
            print(" ".repeat(n-i))
            print("*".repeat(i))
            println()
        }
    }
}