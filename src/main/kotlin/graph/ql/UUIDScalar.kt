package graph.ql

import graphql.Internal
import graphql.language.StringValue
import graphql.language.Value
import graphql.scalars.util.Kit
import graphql.scalars.util.Kit.typeName
import graphql.schema.*
import java.util.*


@Internal
object UUIDScalar {
    var INSTANCE: GraphQLScalarType? = null

    init {
        val coercing: Coercing<UUID?, String?> = object : Coercing<UUID?, String?> {
            private fun convertImpl(input: Any): UUID? {
                if (input is String) {
                    return try {
                        UUID.fromString(input)
                    } catch (ex: IllegalArgumentException) {
                        null
                    }
                } else if (input is UUID) {
                    return input as UUID
                }
                return null
            }

            @Throws(CoercingSerializeException::class)
            override fun serialize(input: Any): String {
                val result: UUID = convertImpl(input)
                    ?: throw CoercingSerializeException(
                        "Expected type 'UUID' but was '" + typeName(input) + "'."
                    )
                return result.toString()
            }

            @Throws(CoercingParseValueException::class)
            override fun parseValue(input: Any): UUID {
                return convertImpl(input)
                    ?: throw CoercingParseValueException(
                        "Expected type 'UUID' but was '" + Kit.typeName(input) + "'."
                    )
            }

            @Throws(CoercingParseLiteralException::class)
            override fun parseLiteral(input: Any): UUID {
                if (input !is StringValue) {
                    throw CoercingParseLiteralException(
                        "Expected a 'java.util.UUID' AST type object but was '" + typeName(input) + "'."
                    )
                }
                return try {
                    UUID.fromString((input as StringValue).getValue())
                } catch (ex: IllegalArgumentException) {
                    throw CoercingParseLiteralException(
                        "Expected something that we can convert to a UUID but was invalid"
                    )
                }
            }

            override fun valueToLiteral(input: Any): Value<*> {
                val s = serialize(input)
                return StringValue.newStringValue(s).build()
            }
        }
        INSTANCE = GraphQLScalarType.newScalar()
            .name("UUID")
            .description("A universally unique identifier compliant UUID Scalar")
            .coercing(coercing)
            .build()
    }
}