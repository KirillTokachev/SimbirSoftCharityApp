package trainingKotlinPart2

sealed class Action {

    object Registration : Action()
    class Login(user: User) : Action()
    object Logout : Action()

}
