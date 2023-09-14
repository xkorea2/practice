package com.example.practice

import javax.security.auth.callback.Callback
import kotlin.math.max
import kotlin.random.Random

const val num = 20

class Box<T>(var value: T) //제네릭

//suspend 정지함수. 실행이 되고 끝날 때 까지 기다림.
suspend fun myFunc(a: Int, callback: () -> Unit = {}) {
    println("함수시작")
    callback()
    println("함수끝")
}


fun main() {

//    myFunc(10) {
//        println("함수호출")
//    }

//    myFunc(10)

    val box = Box<Int>(10)
    val box2 = Box("sdsdsd")

    println(box.value)
    println(box2.value)


    var dog : Animal = Dog()
    var cat = Cat()

//    val dog1 = cat as Dog
//    println(dog1)


    if (dog is Animal) {
        dog.move()
        println("멍멍")
    }


    val john = Person("John", 20)
    println(john.name)
    println(john.age)

    val john2 = Person("John", 20)

    println(john)
    println(john2)

    println("john==john2 ??")
    println(john==john2)

//    john.name = "dd"
    john.age = 23

    println(john.name)
    println(john.age)

//    val plusAge : Int = person.plus_age(john.age)
//    println(plusAge)

    var i = 10
    var l = 20L

    l = i.toLong()

    i = l.toInt()

    var name = "Hello"
    println(name.uppercase())
    println(name.lowercase())
    println(name[0])
    println("내 이름은 ${name + " 10"}입니다.")
    println("내 이름은 $name 입니다.")

    var a = 10
    var b = 20
    println(max(a, b))

    var randomNumber = Random.nextDouble(0.0, 1.0) //0.0~0.9
    println(randomNumber)

//    var reader = Scanner(System.`in`)
//    val nextInt = reader.nextInt()
//    println(nextInt)
//    val next = reader.next()
//    println(next)

    var c = 5
    var result = when {
        c > 10 -> {
            "10보다 크다"
        }
        c > 5 -> {
            "5보다 크다"
        }
        else -> {
            "5 이하이다."
        }
    }
    println(result)

    //boolean result = i > 10 ? true : false;
    var e = 5
    var result1 = if ( e > 10) true else false

    var items = listOf(1, 2, 3, 4, 5)
    items.forEach { item ->
        println(item)
    }
    for (i in 0..3) {
        println(i)
    }

//    val items_mu : MutableList<Int> = mutableListOf<Int>(1, 2, 3, 4, 5)
    val items_mu = mutableListOf(1, 2, 3, 4, 5)
    items_mu.add(6)
    println(items_mu)
    items_mu.remove(3)
    println(items_mu)

    val items_tmp = listOf(1, 2, 3)
//    try {
//        items_tmp.get(4)
//    } catch (e: Exception) {
//        print(e.message)
//    }

    var name1: String? = null
    name1 = "kang"
//    name1 = null

    var name2: String = "hehehe"
    if (name1 != null) {
        name2 = name1
    }
    println(name2)

    name1?.let {
        name2 = name1
    }
    println(name2)

    println(sum(10, 40, 10))
    println(sum(b= 10, a= 40, c=10))

    println(john.hobby)
    john.some()
    println(john.hobby)
//    john.hobby = "swimming"
    println(john.hobby)

    println(john.age)
    john.plus_age()
    println(john.age)

}

//fun sum(a: Int, b: Int): Int {
//    return a+b
//}

fun sum(a: Int, b: Int, c: Int = 0) = a+b+c

data class Person (
    val name: String,
    var age: Int
) {
    var hobby = "축구"
        private set
        get() = "취미: ${field}"

    fun plus_age() {
        age += 1
    }
    init {
    println("init")
    }

    fun some() {
        hobby = "농구"
    }
}

open class Person1

class SuperMan : Person1()

interface Drawable {
    fun draw()
}

abstract class Animal {
    open fun move() {
        println("이동")
    }
}

//Animal 상속받음
class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}
class Cat : Animal() {
    override fun move() {
        println("살금")
    }
}