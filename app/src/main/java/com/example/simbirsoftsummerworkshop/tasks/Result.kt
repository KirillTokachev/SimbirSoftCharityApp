package com.example.simbirsoftsummerworkshop.tasks

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

sealed class FinalResult<T> : Result<T>()

class SuccessResult<T>(
    val data: T
) : FinalResult<T>()

class FailureResult<T>(
    val error: Exception
) : FinalResult<T>()

class PendingResult<T> : FinalResult<T>()

