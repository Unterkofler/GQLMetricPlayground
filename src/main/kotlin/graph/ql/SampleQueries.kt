package graph.ql

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import jakarta.inject.Singleton

@Singleton
class SampleQueries {


    //this function should automatically be listed as a Prometheus metric with name `graphql_query_duration_seconds {name="foo"}`
    fun foo(@GraphQLDescription("A String")aString: String): String {
        return "A String"
    }

    //this function should automatically be listed as a Prometheus metric with name `graphql_query_duration_seconds {name="bar"}`
    fun bar(@GraphQLDescription("A new String") newString: String): String {
        return "A new String"
    }
}