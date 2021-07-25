package dev.olaore.learning_dagger.models

sealed class Result {

    class Success<T>(val data: List<T>): Result()
    object Failure : Result()

}