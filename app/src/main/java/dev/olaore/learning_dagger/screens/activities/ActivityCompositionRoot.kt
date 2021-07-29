package dev.olaore.learning_dagger.screens.activities

import android.app.Activity
import dev.olaore.learning_dagger.common.AppCompositionRoot
import dev.olaore.learning_dagger.networking.StackoverflowApi
import dev.olaore.learning_dagger.questions.FetchQuestionDetailsUseCase
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.screens.common.dialogs.DialogsNavigator
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator

class ActivityCompositionRoot(
    private val appCompositionRoot: AppCompositionRoot,
    private val activity: BaseActivity
) {

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val dialogsNavigator: DialogsNavigator by lazy {
        DialogsNavigator(activity.supportFragmentManager)
    }

    private val stackoverflowApi: StackoverflowApi
        get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase: FetchQuestionsUseCase
        get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
        get() = FetchQuestionDetailsUseCase(stackoverflowApi)

}