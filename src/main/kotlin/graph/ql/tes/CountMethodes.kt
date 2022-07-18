package graph.ql.tes

import io.micrometer.core.annotation.Timed
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Timed("graphql_quiry_duration_seconds")
annotation class CountMethodes(val typeOfClass: KClass<*>) {

   // annotation class CountMethodes(val typeOfClass: KClass<*>, val methodesOfClass: KFunction1<ArrayList<String>>) {


    }