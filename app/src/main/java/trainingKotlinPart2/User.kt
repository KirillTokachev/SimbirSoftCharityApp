package trainingKotlinPart2

import android.util.Log
import java.util.*

data class User(val id: Int, val name: String, val age: Int, val type: Type){

    constructor() : this(0,"",0,Type.DEMO)

    val startTime: String by lazy { "${Calendar.getInstance().time}" }

    fun validate (age: Int){
        if (age > 18) Log.i("test", "User validate") else throw IllegalAccessException("В доступе отказано")
    }

}