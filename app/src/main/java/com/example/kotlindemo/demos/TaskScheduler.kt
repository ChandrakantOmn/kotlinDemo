package com.example.kotlindemo.demos

object TaskScheduler {

    private fun leastInterval(tasks: CharArray, n: Int): Int {
        val taskCounts = IntArray(26)
        for (task in tasks) {
            taskCounts[task - 'A']++
            println("$task : ${taskCounts[task- 'A']}")
        }

        val maxFreq = taskCounts.max()
        val idleTime = (maxFreq - 1) * n
        println("idleTime: $idleTime")
        val maxCount = taskCounts.count { it == maxFreq }
        println("maxCount: $maxCount")

        val totalSlots = (maxFreq - 1) * (n + 1) + maxCount
        println("totalSlots: $totalSlots")

        return maxOf(totalSlots, tasks.size)
    }

    fun solution() {
        //Input: tasks = ["A","A","A","B","B","B"], n = 2
        //Output: 8
        val arr = arrayOf("A", "A", "A", "B", "B", "B")
        val  arr2 = arrayOf("A","A","A","A","A","A","B","C","D","E","F","G")
        val chars: CharArray = arr2.joinToString("").toCharArray()
          println(leastInterval(tasks = chars,2))
    }
}