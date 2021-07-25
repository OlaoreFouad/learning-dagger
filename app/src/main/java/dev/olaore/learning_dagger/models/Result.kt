package dev.olaore.learning_dagger.models

sealed class Result {

    class Success<T>(val data: T): Result()
    object Failure : Result()

}