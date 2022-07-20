package graph.ql

import jakarta.inject.Singleton
import java.time.LocalDate
import java.util.Date


class Reservation(val reservationName: String, val id: Int, val from: String, val to: String) {
    fun getName(): String{
        return reservationName
    }
    fun getid(): Int{
        return id
    }
    fun getFromDate(): String{
        return from
    }
    fun getToDate(): String{
        return to
    }
}