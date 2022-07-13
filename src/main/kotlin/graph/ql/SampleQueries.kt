package graph.ql

class SampleQueries {


    //this function should automatically be listed as a Prometheus metric with name `graphql_query_duration_seconds {name="foo"}`
    fun foo(bar: String): String {
        return ""
    }

    //this function should automatically be listed as a Prometheus metric with name `graphql_query_duration_seconds {name="bar"}`
    fun boo(bar: String) {}
}