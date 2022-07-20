package graph.ql.tes

class PersonTest(_name: String, _lastName: String, _age: Int, _city: String) {
    val name: String
    val lastName: String
    val age: Int
    val city: String

    init {
        name = _name
        lastName = _lastName
        age = _age
        city = _city
    }

    override fun toString(): String {
        return "{firstName: $name, lastName: $lastName, age: $age, city: $city}"
    }
}