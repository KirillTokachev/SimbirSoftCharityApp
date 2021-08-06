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

    val usersName = users.map {it.name}

    Log.i("test", usersName.first())
    Log.i("test", usersName.last())

    val Io = User(77,"Io",45,Type.FULL)

    sleep(Io)

    fullAccess(users)
    
    Io.validate()

    auth(Io, ::updateCache)

    var act: Action = Action.Login(Io)

    doAction(act, Io)

}

fun User.validate () = if (age >= ADULT) Log.d("test", "Permitted") else throw IllegalAccessException("No entry")

fun fullAccess (user: List<User>) : List<User>{
    var fullAccessUser: List<User> = mutableListOf()
    fullAccessUser = user.filter { it.type == Type.FULL }
    Log.d("test", "Полный доступ имеют: " + "$user")
    return fullAccessUser
}

fun updateCache(){
    Log.d("Test","Cache update")
}




inline fun auth(user: User, func: () -> Unit){
    try {
        user.validate()
        obj.authSuccess()
        func()
    } catch (e:Exception) {
        obj.authFailed()
    }
}


fun doAction (action: Action, user: User){
    when (action){
        is Action.Login -> auth(user, ::updateCache)
        is Action.Logout -> Log.d("test", "Logout")
        is Action.Registration -> Log.d("test", "Registered")
    }
}



fun sleep (user: User){
    Log.d("sleep", user.startTime)
    Thread.sleep(1000)
    Log.d("sleep", user.startTime)
}