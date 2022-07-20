package graph.ql

import com.expediagroup.graphql.generator.exceptions.EmptyMutationTypeException.message
import jakarta.inject.Singleton

@Singleton
class SampleQueries {
    var repo: Repository = Repository()

    fun getAllReservations(): List<Reservation> {
        val repository =
        return repo.getAllReservation()
    }

    fun getReservationById(id: Int): List<Reservation> {
        return repo.getReservationById(id)
    }
}