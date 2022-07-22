package graph.ql

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class TestQueries(private val sampleQueries: SampleQueries, private val repository: Repository) {
    @Test
    fun `test querygetallreservations`(){
        val expectetReservations = listOf(sampleQueries.getAllReservations())
        val actualReservation = listOf(repository.db)
        assertEquals(expectetReservations,actualReservation )
    }

    @Test
    fun `test querygetreservationbyid`(){
        val expectet = Reservation("sjdksf", 77, "3434", "3245")
        repository.db.add(Reservation("sjdksf", 77, "3434", "3245"))
        val actual = sampleQueries.getReservationById(77)

        if (actual != null) {
            assertEquals(expectet.id,actual.id)
        }
    }

    @Test
    fun `test querygetreservationbyidExeption`(){
        val expectet: Reservation? = null
        val actual = sampleQueries.getReservationById(79)

        assertEquals(expectet,actual)
    }
}