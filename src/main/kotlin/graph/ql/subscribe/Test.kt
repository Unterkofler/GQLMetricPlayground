package graph.ql.subscribe

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

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
        .collect { println(it) }

    println()
}

//    @OptIn(InternalCoroutinesApi::class)
//    fun main() = runBlocking {
//        getSequence()
//            .collect { value ->
//                println(value)
//            }
//    }
