package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleQueries {
    var repo: Repository = Repository()
    var repoStr: TestRepoForString = TestRepoForString()

    fun getAllReservations(): List<Reservation> {
        return repo.getAllReservation()
    }

    fun getReservationById(id: Int): List<Reservation> {
        return repo.getReservationById(id)
    }

//    fun createString(aString: String) {
//        repoStr.creatString(aString)
//    }
}