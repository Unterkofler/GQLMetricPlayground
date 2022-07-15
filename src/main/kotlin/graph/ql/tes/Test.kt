import graph.ql.tes.Person
import java.lang.reflect.Method

fun main(args: Array<String>){
    val achim: Person = Person("Achim", "Untderkofler", 22, "Dornbirn")
    val name = object{}.javaClass.enclosingMethod.name
    val achimJavaClass = achim.javaClass.declaredMethods
    achimJavaClass

    val  test = achimJavaClass.filter { it -> it.name != null}.forEach({ println(it.name)})

    println("Person: $achim")
    achim.laught()
    achim.speek()
    achim.screem()
    println(achim.countMethod())

    val methodNamesOfPerson = achim.nameMethodOfClass()

    println()
}