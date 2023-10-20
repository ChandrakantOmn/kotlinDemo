package com.example.kotlindemo


/*
fun main(args: Array<String>) {
    print(Student("S1"))
}*/

fun main() {
  //  CandyProblem.candyDistribution2(3,100)
 //   TaskScheduler.solution()
  //  TrapWater.solution()
   // Fibonacci.solution()
   // Factorial.solution()
   // StringManipulation.solution()

    Asteroid.solution()
}


fun getListOfStudents(): List<Student> {
    val list = mutableListOf<Student>()
    for ( i in 1..8){
       list.add(Student("S$i", id =  i))
    }
    return list
}

class Student(var name: String) {
    var id : Int? = null
    constructor(sectionName: String, id: Int) : this(sectionName)
}

@JvmInline
value class Name(val s: String) {
    val length: Int
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }
}

typealias NameTypeAlias = String
@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

class Test(value: Int) {
    val value: Int = value
        get() = if (field < 0) 0 else field

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Test) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

@JvmInline
value class Password(val value: String)
@JvmInline
value class UserName(val value: String)

fun auth(userName: UserName, password: Password) { println("authenticating $userName.")}

data class Test2(private val _value: Int) {
    val value: Int
        get() = if (_value < 0) 0 else _value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Test2) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}


class Car(
    val model: String?,
    val year: Int
) {

    private constructor(builder: Builder) : this(builder.model, builder.year)

    class Builder {
        var model: String? = null
            private set

        var year: Int = 0
            private set

        fun model(model: String) = apply { this.model = model }

        fun year(year: Int) = apply { this.year = year }

        fun build() = Car(this)
    }
}