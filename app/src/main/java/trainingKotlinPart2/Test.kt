package trainingKotlinPart2

import android.util.Log

class Test {
}

fun main() {

    var users = mutableListOf<User>(User(11,"Alex",22,Type.FULL))
    users.apply {
        users.add(User(12,"Bob",23,Type.DEMO))
        users.add(User(13,"Harry",21,Type.DEMO))
        users.add(User(14,"Jhon",25,Type.FULL))
    }

    val usersName = mutableListOf<String>()

    for (User in users){
        usersName.add(User.name)
    }

    Log.i("test", usersName.first())
    Log.i("test", usersName.last())

    val Io = User(77,"Io",45,Type.FULL)

    sleep(Io)

    fullAccess(users)

}


fun fullAccess (user: List<User>) : List<User>{
    var fullAccessUser: List<User> = mutableListOf()
    fullAccessUser = user.filter { it.type == Type.FULL }
    Log.d("test", "Полный доступ имеют: ${user}")
    return fullAccessUser
}

fun updateCache(){
    Log.d("Test","Cache update")
}

inline fun auth (updateCache: User) {
    User().validate(User().age)
}

fun doAction (action: Action){
    when (action){
        Action.Registration() -> Log.i("test", "Registered")
        Action.Login(User()) -> Log.i("test", "Log in ${auth(User())}")
        Action.Logout() -> Log.i("test", "Logout")
    }
}

fun sleep (user: User){
    Log.d("sleep", user.startTime)
    Thread.sleep(1000)
    Log.d("sleep", user.startTime)
}