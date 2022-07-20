package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleMutation {
    var repository: Repository = Repository()

    fun createReservation(reservationName: String, id: Int,from: String, to: String ): String{
        val reservation: Reservation = Reservation(reservationName, id, from, to)
        repository.createReservation(reservation)
        return "OK"
    }
}