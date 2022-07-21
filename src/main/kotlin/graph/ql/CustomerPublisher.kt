package graph.ql

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber


class CustomerPublisher: Publisher<String> {
    private val message = "Message"
    override fun subscribe(s: Subscriber<in String>?) {
        TODO("Not yet implemented")
    }
}