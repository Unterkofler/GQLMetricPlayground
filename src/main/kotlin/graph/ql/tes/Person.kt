package graph.ql.tes

import java.lang.reflect.Method

@CountMethodes
class Person(private val firstName: String, private val  lastName: String, private val age: Int, private val city: String) {

    fun speek(){
        println("${firstName} blablabla")
    }

    fun screem(){
        println("ahhhhhhhh")
    }

    fun laught(){
        println("ahahahahaha")
    }

    fun countMethod(): Int?{
        val count = javaClass.declaredMethods.size
        return count
    }

    fun nameMethodOfClass(): ArrayList<String> {
        val names = javaClass.declaredMethods
        var namesOfMethodes: ArrayList<String> = ArrayList()
        for (name in names){
            val result = name.name
            namesOfMethodes.add(result)
            println("Methoden sind: $result")
        }
        return namesOfMethodes
    }
}