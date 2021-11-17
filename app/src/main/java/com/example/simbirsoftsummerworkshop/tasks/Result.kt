package com.example.simbirsoftsummerworkshop.tasks

import com.example.simbirsoftsummerworkshop.model.Datas

typealias Mapper<Input, Output> = (Input) -> Output

sealed class Result<T> {
    fun <R> map(mapper: Mapper<T, R>? = null): Result<R> = when (this) {
        is PendingResult -> PendingResult()
        is FailureResult -> FailureResult(this.error)
        is SuccessResult -> {
            if (mapper == null) throw IllegalStateException("")
            SuccessResult(mapper(this.data))
        }
    }
}

class SuccessResult<T>(
    val data: T
) : Result<T>()

class FailureResult<T>(
    val error: Exception
) : Result<T>()

class PendingResult<T> : Result<T>()

fun <T> Result<T>?.takeSuccess(): T? {
    return if (this is SuccessResult) this.data else null
}
