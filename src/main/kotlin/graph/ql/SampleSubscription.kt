package graph.ql

import graphql.ExecutionResult
import graphql.GraphQL
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.flowOf
import org.reactivestreams.Publisher
import java.util.concurrent.Flow


@Singleton
class SampleSubscription {
    fun subscription(topic: String): kotlinx.coroutines.flow.Flow<String> {
        val flow = flowOf("first", "second", "third")
        return flow
    }
}