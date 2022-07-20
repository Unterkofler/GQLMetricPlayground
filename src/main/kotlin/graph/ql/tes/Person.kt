package graph.ql.tes

@CountMethodes(typeOfClass = Person::class)
open class Person(private val firstName: String, private val  lastName: String, private val age: Int, private val city: String, private val color: Color) {

    open fun getName(): String{
        return firstName
    }
    open fun getAge(): Int{
        return age
    }
    open fun getColor(): Color{
        return color
    }
    open fun getCity(): String{
        return city
    }
    open fun getLastName(): String{
        return lastName
    }


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
    override fun toString(): String {
        return "{firstName: $firstName, lastName: $lastName, age: $age, city: $city}"
    }
}