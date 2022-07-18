package graph.ql.tes

fun main(args: Array<String>){
    val achim: Person = Person("Achim", "Untderkofler", 22, "Dornbirn")
    val achimJavaClass = achim.javaClass.declaredMethods

    val x = achim.javaClass.getAnnotation(CountMethodes::class.java).toString()

    println("Person: $achim")
    achim.laught()
    achim.speek()
    achim.screem()
    println(achim.countMethod())

    val methodNamesOfPerson = achim.nameMethodOfClass()


    println()
}