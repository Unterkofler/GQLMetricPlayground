package graph.ql

import java.util.UUID


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