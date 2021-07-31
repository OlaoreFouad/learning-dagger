package dev.olaore.learning_dagger.screens.common.di

import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListFragment

class Injector(
    private val compositionRoot: PresentationCompositionRoot
) {

    fun inject(fragment: QuestionsListFragment) {
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }

}