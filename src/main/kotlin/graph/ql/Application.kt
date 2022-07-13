package graph.ql

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
		.args(*args)
		.packages("graph.ql")
		.start()
}

