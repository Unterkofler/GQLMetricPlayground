package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleMutation {

    fun createString(aString: String):String{
        return "OK"
    }
}