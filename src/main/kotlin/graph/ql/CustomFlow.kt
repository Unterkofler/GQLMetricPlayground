package graph.ql

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import java.util.concurrent.Flow

class CustomFlow(list: MutableList<Int> = mutableListOf<Int>()): kotlinx.coroutines.flow.Flow<String> {
    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<String>) {

    }
}