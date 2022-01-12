package com.example.simbirsoftsummerworkshop.tasks

sealed class Result<T>

sealed class FinalResult<T> : Result<T>()

class SuccessResult<T>(
    val data: T
) : FinalResult<T>()

class FailureResult<T>(
    val error: Exception
) : FinalResult<T>()

class PendingResult<T> : FinalResult<T>()

