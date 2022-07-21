package graph.ql

import com.expediagroup.graphql.generator.exceptions.EmptyMutationTypeException.message
import jakarta.inject.Singleton

@Singleton
class SampleQueries(private val repository: Repository) {

    fun getAllReservations(): List<Reservation> {
        return repository.getAllReservation()
    }

    fun getReservationById(id: Int): List<Reservation> {
        return repository.getReservationById(id)
    }
}