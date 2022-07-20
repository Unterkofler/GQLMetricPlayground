package graph.ql

import com.expediagroup.graphql.generator.exceptions.EmptyMutationTypeException.message
import jakarta.inject.Singleton

@Singleton
class SampleQueries {
    var repo: Repository = Repository()
    var repoStr: TestRepoForString = TestRepoForString()

    fun getAllReservations(): List<Reservation> {
        val repository =
        return repo.getAllReservation()
    }

    fun getReservationById(id: Int): List<Reservation> {
        return repo.getReservationById(id)
    }

    fun createString(aString: String): Boolean{
        repoStr.creatString(aString)
        return true
    }
}