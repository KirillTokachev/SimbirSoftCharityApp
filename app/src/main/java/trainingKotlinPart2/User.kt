package trainingKotlinPart2

import android.util.Log
import java.util.*

data class User(val id: Int,
                val name: String,
                val age: Int,
                val type: Type){

    val  ADULT = 18

    constructor() : this(0,"",0,Type.DEMO)

    val startTime: String by lazy { "${Calendar.getInstance().time}" }
}
