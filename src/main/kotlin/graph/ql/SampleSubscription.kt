package graph.ql

import graphql.ExecutionResult
import graphql.GraphQL
import jakarta.inject.Singleton
import org.reactivestreams.Publisher


@Singleton
class SampleSubscription {
    fun subscription(): Publisher<String>{
        //val executionResult: ExecutionResult = GraphQL.execute(query)

        //val stockPriceStream: Publisher<ExecutionResult> = executionResult.getData()
        val pub = CustomerPublisher()
        return pub
    }

}