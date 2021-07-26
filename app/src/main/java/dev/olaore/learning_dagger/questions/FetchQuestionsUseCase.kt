package dev.olaore.learning_dagger.questions

import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.models.Result
import dev.olaore.learning_dagger.networking.StackoverflowApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.cancellation.CancellationException

class FetchQuestionsUseCase(
    private val stackoverflowApi: StackoverflowApi
) {

    suspend fun fetchLatestQuestions(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(
                        response.body()!!.questions
                    )
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }

        }
    }

}