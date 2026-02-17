package profile

class ConditionOlderThan25: Condition {
    override fun isSuitable(person: Person): Boolean = person.age > 25
}