package graph.ql

import com.expediagroup.graphql.generator.SchemaGenerator
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import graphql.GraphQL
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class GQLFactory() {

    @Singleton
    fun graphQL(sampleQueries: SampleQueries, sampleMutation: SampleMutation): GraphQL {
        val config = SchemaGeneratorConfig(
            supportedPackages = listOf(
                "graph.ql",
            )
        )

        val queries = listOf(
            sampleQueries,
        ).map { TopLevelObject(it) }

        val mutation = listOf(
            sampleMutation,
        ).map { TopLevelObject(it) }

        val generator = SchemaGenerator(config)
        val schema = generator.use { it.generateSchema(queries, mutation) }

        return GraphQL.newGraphQL(schema).build()
    }
}