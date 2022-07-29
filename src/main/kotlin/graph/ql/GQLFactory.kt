package graph.ql

import com.expediagroup.graphql.generator.SchemaGenerator
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.execution.FlowSubscriptionExecutionStrategy
import com.expediagroup.graphql.generator.hooks.FlowSubscriptionSchemaGeneratorHooks
import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import graphql.GraphQL
import graphql.execution.ExecutionStrategy
import graphql.execution.SubscriptionExecutionStrategy
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import kotlin.reflect.KClass

@Factory
class GQLFactory {

    @Singleton
    fun graphQL(sampleQueries: SampleQueries, sampleMutation: SampleMutation, sampleSubscription: SampleSubscription): GraphQL {
        val config = SchemaGeneratorConfig(
            supportedPackages = listOf(
                "graph.ql",
            ),
            hooks = FlowSubscriptionSchemaGeneratorHooks()
        )

        val queries = listOf(
            sampleQueries,
        ).map { TopLevelObject(it) }

        val mutation = listOf(
            sampleMutation,
        ).map { TopLevelObject(it) }

        val subscription = listOf(
            sampleSubscription,
        ).map { TopLevelObject(it) }

        val generator = SchemaGenerator(config)
        val schema = generator.use { it.generateSchema(queries, mutation, subscription) }

        return GraphQL.newGraphQL(schema).build() }
}