package dev.olaore.learning_dagger

import android.app.Application
import dev.olaore.learning_dagger.common.AppCompositionRoot
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.FetchQuestionDetailsUseCase
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    lateinit var root: AppCompositionRoot

    override fun onCreate() {
        root = AppCompositionRoot()
        super.onCreate()
    }

}