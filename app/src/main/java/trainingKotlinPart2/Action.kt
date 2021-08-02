package trainingKotlinPart2

sealed class Action {

    class Registration() : Action()
    class Login(user: User) : Action()
    class Logout() : Action()

}
