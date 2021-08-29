package dev.olaore.learning_dagger.questions

import android.os.Build
import android.text.Html
import dev.olaore.learning_dagger.Constants
import dev.olaore.learning_dagger.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dev.olaore.learning_dagger.models.Result
import javax.inject.Inject

class FetchQuestionDetailsUseCase @Inject
    constructor(
        private val stackoverflowApi: StackoverflowApi
    ) {

    suspend fun fetchQuestionDetails(questionId: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    val question = response.body()!!.question
                    return@withContext Result.Success(question)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                return@withContext Result.Failure
            }

        }
    }

}