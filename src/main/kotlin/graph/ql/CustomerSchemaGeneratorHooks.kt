package graph.ql

import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import com.fasterxml.jackson.databind.JsonNode
import graphql.scalars.ExtendedScalars
import graphql.scalars.ExtendedScalars.DateTime
import graphql.schema.GraphQLType
import kotlin.reflect.KClass
import kotlin.reflect.KType

    class CustomSchemaGeneratorHooks : SchemaGeneratorHooks {
        override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier as? KClass<*>) {
            DateTime::class -> ExtendedScalars.DateTime
            JsonNode::class -> ExtendedScalars.Json
            else -> null
        }
    }