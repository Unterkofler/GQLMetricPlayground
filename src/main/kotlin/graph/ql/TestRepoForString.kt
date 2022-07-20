package graph.ql

class TestRepoForString {
    val db = mutableListOf<String>()

    fun creatString(input: String){
        db.add(input)
    }
}