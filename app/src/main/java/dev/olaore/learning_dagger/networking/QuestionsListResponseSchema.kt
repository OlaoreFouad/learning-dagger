package dev.olaore.learning_dagger.networking

import com.google.gson.annotations.SerializedName
import dev.olaore.learning_dagger.questions.Question


class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)