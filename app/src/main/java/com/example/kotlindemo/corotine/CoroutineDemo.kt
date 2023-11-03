package com.example.kotlindemo.corotine

import com.example.kotlindemo.Solution
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

object CoroutineDemo : Solution<String>() {
    override var className: String = "CoroutineDemo"
    override var result: String = ""

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun solution() {
        runBlocking {
            val flow = streamInt()
            flow.mapLatest {
                println("latest $it")
            }
            flow.collect {
                println(it)
            }
        }

        runBlocking {
            val flow1 = flowOf(1, 2, 3)
            val flow2 = flowOf(4, 5, 6)
            val result = flow1.combine(flow2) { v1, v2 ->
                println("Multiplied result: $v1  $v2")
                v1 + v2
            }
            result.collect { r ->
                println("Multiplied result: $r")
            }
            val multipliedFlow: Flow<Int> = flow1.zip(flow2) { value1, value2 ->
                value1 * value2
            }
            multipliedFlow.collect { result ->
                println("Multiplied result: $result")
            }
        }
    }

    private fun streamInt(): Flow<List<Int>> {
        return flow {
            val list1 = listOf(1, 2, 3, 4, 5)
            val list2 = listOf(6, 7, 8, 9, 10)
            emit(list1)
            emit(list2)
        }
    }
}