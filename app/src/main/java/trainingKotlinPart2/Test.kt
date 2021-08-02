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


}


fun fullAccess (user: List<User>){
    user.forEach { if (it.type == Type.FULL) Log.i("test", "Полный доступ имеют: ${it.name}") }
}

fun updateCache(){
    Log.i("Test","Cache update")
}

inline fun auth (updateCache: () -> Unit) {
    if (User().age >= 18){
        obj.authSuccess()
        updateCache()
    } else {
        obj.authFailed()
    }
}

fun doAction (action: Action){
    when (action){
        Action.Registration() -> Log.i("test", "Registered")
        Action.Login(User()) -> auth { updateCache() }
        Action.Logout() -> Log.i("test", "Logout")
    }
}