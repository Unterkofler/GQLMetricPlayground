package graph.ql.tes

import kotlin.reflect.full.functions

@CountMethodes(typeOfClass = Person::class)
//@CountMethodes(typeOfClass = Person::class, methodesOfClass = Person::nameMethodOfClass)
open class Person(private val firstName: String, private val  lastName: String, private val age: Int, private val city: String) {

    open fun speek(){
        println("${firstName} blablabla")

    }

    open fun screem(){
        println("ahhhhhhhh")
    }

    open fun laught(){
        println("ahahahahaha")
    }

    open fun countMethod(): Int?{
        val count = javaClass.declaredMethods.size
        return count
    }

    open fun nameMethodOfClass(): ArrayList<String> {
        val names = javaClass.declaredMethods
        var namesOfMethodes: ArrayList<String> = ArrayList()
        var diaNamen: String = String()
        for (name in names){
            val result = name.name
            diaNamen += name.name + ' '
            namesOfMethodes.add(result)
            println("Methoden sind: $result")
        }


        return namesOfMethodes
    }
}