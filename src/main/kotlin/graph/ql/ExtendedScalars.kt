package graph.ql

import graphql.schema.GraphQLScalarType

class ExtendedScalars {
    var UUID: GraphQLScalarType? = UUIDScalar.INSTANCE
}