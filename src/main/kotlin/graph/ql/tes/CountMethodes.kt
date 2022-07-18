package graph.ql.tes

import io.micronaut.core.annotation.ReflectionConfig
import kotlin.reflect.KClass
import kotlin.reflect.KFunction1

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CountMethodes(val typeOfClass: KClass<*>) {

   // annotation class CountMethodes(val typeOfClass: KClass<*>, val methodesOfClass: KFunction1<ArrayList<String>>) {


    }