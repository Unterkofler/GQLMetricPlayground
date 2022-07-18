package graph.ql.tes

import graph.ql.Person

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CountMethodes()

fun getClass(person: Person) {

}
