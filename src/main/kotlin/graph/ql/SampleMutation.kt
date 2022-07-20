package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleMutation {
    var testRepoForString: TestRepoForString = TestRepoForString()
    fun createString(aString: String):String{
        testRepoForString.creatString(aString)
        return "OK"
    }
}