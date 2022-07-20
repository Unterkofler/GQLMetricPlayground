package graph.ql

import jakarta.inject.Singleton

@Singleton
class Repository {
        val db = mutableListOf<Reservation>(Reservation("achim", 1, "2022-08-02", "2022-09-01"),
            Reservation("achim", 2,"2023-08-02", "2023-09-01"),
            Reservation("achim", 3, "2023-07-02", "2023-08-01"),
            Reservation("achim", 4, "2023-06-02", "2023-07-01"),
            Reservation("achim", 5, "2023-05-02", "2023-06-01"),
            Reservation("achim", 6, "2023-04-02", "2023-05-01"))

    fun getAllReservation(): List<Reservation> {
        return db.filter { it.id.javaClass == Int::class.java }
    }

    fun getReservationById(id: Int): List<Reservation> {
        return db.filter { it.id == id }
    }
}