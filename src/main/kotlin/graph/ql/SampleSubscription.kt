package graph.ql

import jakarta.inject.Singleton
import org.reactivestreams.Publisher


@Singleton
class SampleSubscription {

    fun subscription(): Publisher<String>{
        return CustomerPublischer()
    }

}