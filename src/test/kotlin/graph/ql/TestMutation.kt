package graph.ql

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class TestMutation (private val sampleMutation: SampleMutation, private val repository: Repository){

    @Test
    fun `test mutation`(){
        val expected = repository.db.size + 1
        sampleMutation.createReservation("bob", "6", "90")
        val actual = repository.db.size

        assertEquals(expected, actual)
    }
}