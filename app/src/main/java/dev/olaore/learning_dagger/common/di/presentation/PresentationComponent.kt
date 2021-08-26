package dev.olaore.learning_dagger.common.di.presentation

import dagger.Component
import dev.olaore.learning_dagger.common.di.activity.ActivityComponent
import dev.olaore.learning_dagger.questions.FetchQuestionDetailsUseCase
import dev.olaore.learning_dagger.questions.FetchQuestionsUseCase
import dev.olaore.learning_dagger.screens.common.dialogs.DialogsNavigator
import dev.olaore.learning_dagger.screens.common.navigation.ScreensNavigator
import dev.olaore.learning_dagger.screens.common.viewmvcs.ViewMvcFactory
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsActivity
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListFragment

@PresentationScope
@Component(modules = [PresentationModule::class], dependencies = [ActivityComponent::class])
interface PresentationComponent {

    fun inject(fragment: QuestionsListFragment)

    fun inject(aktivity: QuestionDetailsActivity)

}