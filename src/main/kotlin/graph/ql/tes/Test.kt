package graph.ql.tes

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import graph.ql.GFG
import graph.ql.SampleSubscription
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.util.Observable

data class User(val id: String, val age: Int)

fun User.toJson(): String = ObjectMapper().writeValueAsString(this)
fun String.toUser(): User = ObjectMapper().readValue(this)
suspend fun main(args: Array<String>){

    val namesFlow = flow {
        val names = listOf("Jody", "Steve", "Lance", "Joe")
        for (name in names) {
            delay(100)
            emit(name)
        }
    }




    fun main() = runBlocking {
        namesFlow
            .map { name -> name.length }
            .filter { length -> length < 5 }
            .collect { println(it) }

        println()
    }

    val user = User("kdjfskd", 33)

    println(user.toJson())

    val people = listOf("Jody", "Steve", "Lance", "Joe")

    val peopleMap = people.map { it }
    println(peopleMap)
    val peopleMapMap = people.map { it }.map { it.toUpperCase() }
    println(peopleMapMap)

    people.map { it }.map { it.toUpperCase() }.forEach{ println(it.reversed()) }


    GFG().initializeName()

    val bob: Person = Person("bob","zoller", 33, "Wien", Color.RED)
    val stefan: Person = Person("stefan","zoller", 83, "Wien", Color.BLUE)
    val nadja: Person = Person("nadja","zoller", 93, "Wien", Color.GREEN)
    var gerd: Person = Person("gerd","zoller", 3, "Wien", Color.RED)

    val bob1: PersonTest = PersonTest("bob","zoller", 33, "Wien")
    val stefan1: PersonTest = PersonTest("stefan","zoller", 83, "Wien")
    val nadja1: PersonTest = PersonTest("nadja","zoller", 93, "Wien")
    val gerd1: PersonTest = PersonTest("gerd","zoller", 3, "Wien")




    println("Liste initialisiert es gib 3 Listen: ListInt, ListString, ListPerson, map")
    val listInt = listOf(22,2,13,12,44,55,66)
    val listString = listOf("22","2","13","12")
    val listPerson = listOf(bob,stefan,nadja,gerd)
    val map: Map<Int, String> = mapOf(2 to "zwei", 4 to "vier", 6 to "sechs", 8 to "acht", 10 to "zehn")
    println("ListInt hat folgende Werte: $listInt")
    println("ListString hat folgende Werte: $listString")
    println("ListPerson hat folgende Werte: ${listPerson.toString()}")
    println("map hat folgende Werte: $map")
    println()

    println("ListInt filtered by value < 4: ${listInt.filter { it < 4 }}")


    val newmap = map.filter { it.key > 4 && (it.value.equals("acht") or it.value.equals("zehn"))  }
    println("it.key > 4 && ((it.value.equals(\"acht\")) or (it.value.equals(\"zehn\")) = $newmap}")

    val abc = map.filter { (key, value) -> key < 3 && value.endsWith("i") }
    println("{ (key, value) -> key < 3 && value.endsWith(\"i\") } = $abc")

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) ->  value > 10 && key.endsWith("1")}

    //transform a list to a map
    val mapPerson = listPerson.map { it.getName() to it.getAge() }.toMap()
    println("val mapPerson = listPerson.map { it.getName() to it.getAge() }.toMap() = $mapPerson")

    listPerson.forEach{ println(it.toString()) }

    val newStringlist = listString.forEach({it})

    val filteredList = listString.filter { it.length < 2 }

    val numbers = listOf("one", "two", "three", "four")

    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5)  }
    val filteredNot = numbers.filterNot { it.length <= 3 }

    var stringList = mutableListOf<String>()
    stringList.add("aaaa")
    stringList.add("bbbb")
    stringList.add("uuuu")


    println()
    println("associateBy function on a list")
    val numbers1 = listOf("eins", "zwei", "drei", "vier", "fünf", "sechs")
    val nubersassociateBy = numbers1.associateBy { it.first().toUpperCase() }
    val numbersassociateByKey = numbers1.associateBy(keySelector = {it.first().toUpperCase()}, valueTransform = {it.length })
     println("$nubersassociateBy")
    println("$numbersassociateByKey")

    println()
    println("LOOPS")
    numbersassociateByKey.forEach {(key, value) -> println("$key -> $value")}
    println()

    println("run und let")
    var something: String = "hallo dere!!!!"
    something.let { println("$it") }
    val somethingLength = something.let { "it Funcution" }
    something = run { val something = "dkjks"
                    something}
    println("$something")
    println()

    if (something.length < 1000){
        println("something.length is smaller than 1000")
    }

    when(gerd.getColor()){
        Color.GREEN -> println("GREEN")
        Color.BLUE -> println("BLUE")
        Color.RED -> println("Red")
    }

    //Testing the class Flow
    val flow = flowOf("first", "second", "third")

    println()
    println("Lamdafunctions")

    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)


    println()
    println("anonyme Funktionen")
    val anonymeFunktion = { println("anonymeFunktion")}
    anonymeFunktion()
    anonymeFunktion.invoke()


    // with type annotation in lambda expression
    val sum1 = { a: Int, b: Int -> a + b }

// without type annotation in lambda expression
    val sum2:(Int,Int)-> Int  = { a , b -> a + b}

    val result1 = sum1(4,4)
    val result2 = sum2(5,5)
    println("4+4 result1 = $result1")
    println("5+5 result2 = $result2")

    val evenOrOdd = fun (num: Int): String {
        if (num < 0 && num % 2 == 0){
            return "num is negativ and even"
        }
        else if(num > 0 && num % 2 == 0){
            return "num is positiv and even"
        }
        else if (num < 0 && num % 2 != 0){
            return "num is negativ and odd"
        }
        else if (num > 0 && num % 2 != 0){
            return "num is positiv and odd"
        }else
            return "num is zero"
    }

    val isItEvenOrOdd = evenOrOdd(0)
    println(isItEvenOrOdd)

    val multi = fun(a: Int, b: Int): Int {
         return a * b
    }
    println(multi(8,8))

//    println(filteredIdx)
//    println(filteredNot)
//
//
//
//
//    val achim: Person = Person("Achim", "Untderkofler", 22, "Dornbirn")
//    val achimJavaClass = achim.javaClass.declaredMethods
//
//    val x = achim.javaClass.getAnnotation(CountMethodes::class.java).toString()
//
//    println("Person: $achim")
//    achim.laught()
//    achim.speek()
//    achim.screem()
//    println(achim.countMethod())
//
//    val xy = Person::class.java.declaredMethods.toList()
//
//    val methodNamesOfPerson = achim.nameMethodOfClass()
//
//
//    println()
}