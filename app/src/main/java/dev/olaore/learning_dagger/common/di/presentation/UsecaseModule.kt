package dev.olaore.learning_dagger.common.di.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.FetchQuestionDetailsUseCase
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.screens.common.dialogs.DialogsNavigator
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.common.viewmvcs.ViewMvcFactory

@Module
class UsecaseModule() {

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionsUseCase
        = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionDetailsUseCase
        = FetchQuestionDetailsUseCase(stackoverflowApi)

}