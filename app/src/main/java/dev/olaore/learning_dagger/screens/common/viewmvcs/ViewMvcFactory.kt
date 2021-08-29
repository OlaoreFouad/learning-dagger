package dev.olaore.learning_dagger.screens.common.viewmvcs

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.olaore.learning_dagger.screens.questiondetails.QuestionDetailsViewMvc
import dev.olaore.learning_dagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject
    constructor(
        private val layoutInflater: LayoutInflater
    ) {

    fun newQuestionListViewMvc(container: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, container)
    }

    fun newQuestionDetailsViewMvc(container: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, container)
    }

}