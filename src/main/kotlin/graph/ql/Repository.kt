package graph.ql

import jakarta.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Singleton
class Repository() {

        var db = mutableListOf<Reservation>(Reservation("achim", 1, "2022-08-02", "2022-09-01", "kdjskdjskkdjdk"),
            Reservation("achim", 2,"2023-08-02", "2023-09-01","dkjkdjfskd"),
            Reservation("achim", 3, "2023-07-02", "2023-08-01", "lkdjksjsljsd"),
            Reservation("achim", 4, "2023-06-02", "2023-07-01","ljksllsdlsjlnv"),
            Reservation("achim", 5, "2023-05-02", "2023-06-01", "jsjiieef"),
            Reservation("achim", 6, "2023-04-02", "2023-05-01", "lsjioiciz"))

    fun getAllReservation(): List<Reservation> {
        return db.filter { it.id.javaClass == Int::class.java }
    }

    fun getReservationById(id: Int): Reservation? {
        try {
            return db.filter { it.id == id }[0]
        }catch (e: Exception){
            println(e)
        }
        return null
    }

    fun createReservation(reservation: Reservation){
        db.add(reservation)
    }
}