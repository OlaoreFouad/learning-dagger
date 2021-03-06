package dev.olaore.learning_dagger.networking

import com.google.gson.annotations.SerializedName
import dev.olaore.learning_dagger.questions.QuestionWithBody

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}