package profile

object ConditionFnStartWithA: Condition {
    override fun isSuitable(person: Person): Boolean = person.firstName.startsWith("A")
}