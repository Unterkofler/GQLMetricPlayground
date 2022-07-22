package graph.ql

import jakarta.inject.Singleton
import kotlinx.coroutines.flow.flowOf


@Singleton
class SampleSubscription(repository: Repository) {
    fun subscription(topic: String): kotlinx.coroutines.flow.Flow<String> {
        return flowOf("first", "second", "third")
    }
}