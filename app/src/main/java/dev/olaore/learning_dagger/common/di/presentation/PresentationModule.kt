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
class PresentationModule(
    private val component: ActivityComponent
) {

    @Provides
    fun layoutInflater(): LayoutInflater
        = component.layoutInflater()

    @Provides
    fun fragmentManager(): FragmentManager
        = component.fragmentManager()

    @Provides
    fun stackoverflowApi(): StackoverflowApi
        = component.stackoverflowApi()

    @Provides
    fun screensNavigator(): ScreensNavigator
        = component.screensNavigator()

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater): ViewMvcFactory
        = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager): DialogsNavigator
        = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionsUseCase
        = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionDetailsUseCase
        = FetchQuestionDetailsUseCase(stackoverflowApi)

}