package trainingKotlinPart2

import android.util.Log

interface AuthCallback {

    fun authSuccess()
    fun authFailed()

}

val obj = object : AuthCallback {
    override fun authSuccess() {
        Log.d("auth", "Authentication is success")
    }

    override fun authFailed() {
        Log.d("auth", "Authentication is failed")
    }
}