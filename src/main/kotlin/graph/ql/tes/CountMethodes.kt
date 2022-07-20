package graph.ql.tes

import io.micrometer.core.annotation.Timed
import kotlin.reflect.KClass
import kotlin.reflect.KFunction1

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Timed("graphql_quiry_duration_seconds")
annotation class CountMethodes(val typeOfClass: KClass<*>) {
    }