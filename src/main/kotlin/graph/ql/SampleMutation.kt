package graph.ql

import jakarta.inject.Singleton

@Singleton
class SampleMutation(private val repository: Repository) {
    fun createReservation(reservationName: String, from: String, to: String, comment: String ): String{
        repository.createReservation(Reservation(reservationName,repository.db.size +1, from,to, comment))
        return "OK"
    }

}