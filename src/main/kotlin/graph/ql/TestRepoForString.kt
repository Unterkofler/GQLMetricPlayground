package graph.ql

import jakarta.inject.Singleton

@Singleton
class TestRepoForString {
    val db = mutableListOf<String>()

    fun creatString(input: String){
        db.add(input)
    }
}