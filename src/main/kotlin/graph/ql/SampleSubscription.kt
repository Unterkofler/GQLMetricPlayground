package graph.ql

import jakarta.inject.Singleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


@Singleton
class SampleSubscription(private val repository: Repository) {
    fun subscription(topic: String) = flow {
        repeat(10){
            delay(1000)
            emit(it)
        }
    }
}
