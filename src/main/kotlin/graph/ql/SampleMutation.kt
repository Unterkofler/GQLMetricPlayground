package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleMutation(private val repository: Repository) {

    fun createReservation(reservationName: String,from: String, to: String ): String{
        val reservation: Reservation = Reservation(reservationName, repository.db.size + 1, from, to)
        repository.createReservation(reservation)
        return "OK"
    }
}