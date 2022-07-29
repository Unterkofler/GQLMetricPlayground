package graph.ql

class GFG {
    lateinit var myVariable: String
    fun initializeName() {
        println("is myVariable initialized? " + this::myVariable.isInitialized)

        myVariable = "A String"

        println("is myVariable initialized? " + this::myVariable.isInitialized)
    }
}