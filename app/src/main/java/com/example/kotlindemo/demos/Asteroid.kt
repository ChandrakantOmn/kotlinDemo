package com.example.kotlindemo.demos

import java.util.Stack
import kotlin.math.abs

//    getAstrroids(arryOf(10, 2, -5))
object Asteroid {
    fun solution(){
        asteroidCollisionStack(intArrayOf(10,2,6,-15,10,-5, 20, -9, -16 )).map {
            println(it)
        }

    }

    private fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        for (asteroid in asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.add(asteroid)
            } else {
                while (stack.isNotEmpty() ) {
                    val top = stack.removeAt(stack.size - 1)
                    if (top == -asteroid) {
                        break
                    } else if (top > abs(asteroid)) {
                        stack.add(top)
                        break
                    }else if (top< abs(asteroid)){
                        if(stack.isEmpty()){
                            stack.add(asteroid)
                            break
                        }
                    }
                }
            }
        }

        return stack.toIntArray()
    }
    private fun asteroidCollisionStack(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.add(asteroid)
            } else {
                while (stack.isNotEmpty() ) {
                    val top = stack.pop()
                    if (top == -asteroid) {
                        break
                    } else if (top > abs(asteroid)) {
                        stack.push(top)
                        break
                    }else if (top< abs(asteroid)){
                        if(stack.isEmpty()){
                            stack.push(asteroid)
                            break
                        }
                    }
                }
            }
        }

        return stack.toIntArray()
    }

}