package dev.olaore.learning_dagger.common.di

import dev.olaore.learning_dagger.common.di.presentation.PresentationComponent
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListFragment

class Injector(
    private val component: PresentationComponent
) {

    fun inject(fragment: QuestionsListFragment) {
        fragment.screensNavigator = component.screensNavigator()
        fragment.dialogsNavigator = component.dialogsNavigator()
        fragment.fetchQuestionsUseCase = component.fetchQuestionsUseCase()
        fragment.viewMvcFactory = component.viewMvcFactory()
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.screensNavigator = component.screensNavigator()
        activity.dialogsNavigator = component.dialogsNavigator()
        activity.fetchQuestionDetailsUseCase = component.fetchQuestionDetailsUseCase()
        activity.viewMvcFactory = component.viewMvcFactory()
    }

}