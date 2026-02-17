package profile

object ConditionMales: Condition {
    override fun isSuitable(person: Person): Boolean = person.gender == Gender.MALE
}